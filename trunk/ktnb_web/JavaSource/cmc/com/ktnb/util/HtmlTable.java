package cmc.com.ktnb.util;

import java.util.Collection;

public class HtmlTable {
	public Collection data;
	long ordinal = 0;
	private long pageNumber = 1;
	private long lpageCount = 1;
	private String navigationBar = "";
	private String searchForm = "";
	private long pageSize = 10;
	private String goToPageUrl = "";
	private String idTag = "";
	private String javascript = "";
	private String searchFormAction = "";
	private long totalRecord = 0;
	private long pageNumberShow = 5;
	private String tableTarget = null;
	private String functionAjaxName;

	public HtmlTable() {
		data = null;
	}

	/*
	 *Lay ra collection theo trang
	 *@return collection 
	 */
	public Collection getData() {
		if(data!=null){		
			PagingCollection paging = new PagingCollection(pageNumber, pageSize, data);
			return paging.getCollection();
		}
		else return null;
	}

	public void setData(Collection newData) {
		data = newData;
		setTotalRecord(newData.size());
	}

	public long getOrdinal() {
		this.ordinal = this.ordinal + 1;
		return (pageNumber - 1) * this.pageSize + this.ordinal;
	}

	public void setPageNumber(String newPageNumber) {
		if (newPageNumber != null && !newPageNumber.equals("")) {
			this.pageNumber = Long.parseLong(newPageNumber);
		} else {
			this.pageNumber = 1;
		}
	}

	public String getNavigationBar() {
		this.ordinal = 0;
		this.getPageCount();
		long startPage = (this.pageNumber / this.pageNumberShow) * this.pageNumberShow;
		if (startPage == this.pageNumber) {
			startPage = startPage + 1 - this.pageNumberShow;
		} else {
			startPage = startPage + 1;
		}
		long endPage = startPage + this.pageNumberShow - 1;
		if (endPage > lpageCount)
			endPage = lpageCount;
		String strBar = "";
		strBar += "<table border='0' width='100%'>";
//		strBar += "<tr>";
//		strBar += "<td width='13'>&nbsp;</td>";
//		strBar += "<td>";
//		strBar += "</td>";
//		strBar += "<td align='right'>";
//		strBar += "<td>";
//		strBar += "</tr>";
		strBar += "<tr>";
		strBar += "<td width='13'>&nbsp;</td>";
		strBar += "<td  align=left>";
		strBar += "<Div align=center style = \"text-align: center;\">";
		if (startPage > this.pageNumberShow) {
			strBar += "<a href='javascript:gotoPage" + this.idTag + "(" + (startPage - this.pageNumberShow) + ")'>&lt;&lt;</a>";
			strBar += "&nbsp;&nbsp;";
		}
		for (int i = 1; i <= this.lpageCount; i++) {
			if (i == pageNumber) {
				strBar += "<font color='red'> [" + i + "] </font>";
				if (i < endPage)
					strBar += " - ";
			} else if ((i >= startPage) && (i <= endPage)) {
				strBar += "<a href='javascript:gotoPage" + this.idTag + "(" + i + ")'>" + i + "</a>";
				if (i < endPage)
					strBar += " - ";
			}
			if (i == endPage)
				break;

		}
		if (endPage < lpageCount) {
			strBar += "&nbsp;&nbsp;<a href='javascript:gotoPage" + this.idTag + "(" + (endPage + 1) + ")'>&gt;&gt;</a>";
		}
		strBar += "</div>";
		strBar += "</td>";
		strBar += "</tr>";
		strBar += "</table>";

		String script = this.createJavascript();
		this.navigationBar = strBar + "\n" + script;
		return strBar + "\n" + script;
	}

	public void setSearchForm(String newSearchForm) {
		searchForm = newSearchForm;
	}

	public void setPageSize(long newPageSize) {
		pageSize = newPageSize;
	}

	public void setGoToPageUrl(String newGoToPageUrl) {
		goToPageUrl = newGoToPageUrl;
	}

	private void getPageCount() { //modify by KTDung
		//long tmp=data.size()/pageSize;
		long tmp = this.getTotalRecord() / pageSize;
		if (tmp * pageSize == this.getTotalRecord()) {
			this.lpageCount = tmp;
		} else {
			this.lpageCount = tmp + 1;
		}
	}

	private String createJavascript() {
		if (!this.javascript.equals("")) {
			return this.javascript;
		}
		String strHidden = "";
		String script = "";

		script += "<script language=\"javascript\">";
		script += "function gotoPage" + this.idTag + "(pageNumber)";
		script += "{";
		if (!this.searchForm.equals("")) {
			if (this.searchFormAction.equals("")) {
				script += "   var strAction=" + this.searchForm + ".action;";
				script += "   if (strAction.indexOf('?')==-1)";
				script += "   strAction=strAction+'?pageNumber" + this.idTag + "='+pageNumber;";
				script += "   else";
				script += "   strAction=strAction+'&pageNumber" + this.idTag + "='+pageNumber;";
				if ((this.tableTarget != null) && (this.tableTarget.trim().length() > 0)) {
					script += "   strAction=strAction+'#" + this.tableTarget + "';";
				}
			} else {
				script += "   var strAction='" + this.searchFormAction + "';";
				if (this.searchFormAction.indexOf("?") != -1) {
					script += "   strAction=strAction+'&pageNumber" + this.idTag + "='+pageNumber;";
				} else {
					script += "   strAction=strAction+'?pageNumber" + this.idTag + "='+pageNumber;";
				}
				if ((this.tableTarget != null) && (this.tableTarget.trim().length() > 0)) {
					script += "   strAction=strAction+'#" + this.tableTarget + "';";
				}
			}
			script += "   " + this.searchForm + ".action=strAction;";
			script += "   " + this.searchForm + ".submit();";
			if (this.functionAjaxName == null) {
				script += "   " + this.searchForm + ".action=strAction;";
				script += "   " + this.searchForm + ".submit();";
			} else {
				script += this.functionAjaxName + "(strAction,\"" + this.searchForm + "\");\n";
			}
		} else {
			String tmp = "'';";
			if ((this.tableTarget != null) && (this.tableTarget.trim().length() > 0)) {
				tmp = "'#" + this.tableTarget + "';";
			}
			if (this.goToPageUrl.indexOf("?") == -1) {
				script += "window.location='" + this.goToPageUrl + "?pageNumber" + this.idTag + "=' + pageNumber+" + tmp;
			} else {
				script += "window.location='" + this.goToPageUrl + "&pageNumber=" + this.idTag + "' + pageNumber+" + tmp;
			}
		}
		script += "}";
		script += "</script>";

		return script;
	}

	public void setScriptIdTag(String theIdTag) {
		this.idTag = theIdTag;
	}

	public void setJavascript(String newJavascript) {
		javascript = newJavascript;
	}

	public String getSearchFormAction() {
		return searchFormAction;
	}

	public void setSearchFormAction(String newSearchFormAction) {
		searchFormAction = newSearchFormAction;
	}

	public long getTotalRecord() {
		long retVal = (this.pageNumber - 1) * this.pageSize +1;
		retVal = (retVal -1) + totalRecord;		
		return retVal;
	}
	public long getCurrentTotalRecord() {
		long retVal = 0;
		if(getData()!=null && getData().size()>0){
			retVal = (this.pageNumber-1) * this.pageSize + getData().size();
		}
		return retVal;
	}
	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public long getPageNumberShow() {
		return pageNumberShow;
	}

	public void setPageNumberShow(long pageNumberShow) {
		this.pageNumberShow = pageNumberShow;
	}

	public long getPageSize() {
		return pageSize;
	}

	public long getPageNumber() {
		return pageNumber;
	}

	public void setTableTarget(String tableTarget) {
		this.tableTarget = tableTarget;
	}

	public String getTableTarget() {
		return tableTarget;
	}

	public String getFunctionAjaxName() {
		return functionAjaxName;
	}
	public void setFunctionAjaxName(String string) {
		functionAjaxName = string;
	}

}