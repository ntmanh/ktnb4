/*
 * Created on Dec 20, 2010
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.web.ttkt.dung_chung.action;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbTreeNode;
import cmc.com.ktnb.web.BaseDispatchAction;

/**
 * @author Nguyen Tien Dung
 * 
 * To change the template for this generated type comment go to Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ChiTietNoiDungTtktAction extends BaseDispatchAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// KtnbTreeNode root = buidTree(request.getParameter("root"));
		String rootId = request.getParameter("root");
		KtnbTreeNode root = new KtnbTreeNode(rootId, "Goc noi dung", -1);
		root.addChild();
		request.setAttribute("danhMucTtktTree", genHTML(root));
		return mapping.findForward("search");
	}

	private String genHTML(KtnbTreeNode root) {
		Collection childList = root.getListChild();
		if (Formater.isNull(childList))
			return "";
		String reVal = "";
		for (int i = 0; i < childList.size(); i++)
			reVal += disPlayNode((KtnbTreeNode) ((ArrayList) childList).get(i));
		reVal = "<table height=\"100%\" width=\"576\" border=\"0\" id=\"tblChiTietNoiDung\" style = \"table-layout:fixed\">" + reVal;
		reVal += "</table>";
		return reVal;
	}

	int iIndent = 0;
	private String disPlayNode(KtnbTreeNode treeNode) {

		int reIndent = iIndent;
		String reVal = "";
		String ma = treeNode.getMa();
		String text = treeNode.getText();
		String display = iIndent < 1 ? "style = 'display: inline;'" : "style = 'display: none;'";
		if (treeNode.isLeaf())
			reVal = "\n<tr id = '" + ma + "' " + display + " height=\"20\" style=\"overflow: hidden; padding-top: 8; padding-bottom: 8\" title = '" + text + "'>\n";
		else
			reVal = "\n<tr id = '" + ma + "' " + display + " height=\"20\" style=\"overflow: hidden; padding-top: 7; padding-bottom: 7\" title = '" + text + "'>\n";
		reVal += "<td width='11%'><input type=\"hidden\" id = 'enable' name=\"parentId" + ((KtnbTreeNode) treeNode.getParent()).getMa() + "\"><input name = \"" + treeNode.getLevel()
				+ "\" type = \"hidden\">" + "<font color=\"blue\">" + ma + "</font>" + "\n</td>\n";
		reVal += "<td width='85%' style='overflow: hidden;'>\n";
		reVal += "<span class=\"description\">\n";
		for (int j = 0; j < iIndent; j++)
			reVal += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		if (treeNode.isLeaf())
			reVal += text;
		else {
			reVal += "<span class=\"description\"><a href='#' onclick='expandThisNode(\"" + ma + "\");' style = 'display:inline;' id = '" + ma + "+' style=\"text-decoration: none\">";
			reVal += "<font color=\"blue\"><b>+ " + text + "</b></font>";
			reVal += "</a>\n";
			reVal += "<a href='#' onclick='expandThisNode(\"" + ma + "\");' style = 'display:none;'   id = '" + ma + "-' style=\"text-decoration: none\">";
			reVal += "<font color=\"blue\"><b>- " + text + "</b></font>";
			reVal += "</a>\n";

		}
		reVal += "</span>";
		reVal += "</td>\n";
		reVal += "<td align=\"center\" width='4%'>\n";
		reVal += "<INPUT type='checkbox' onclick='selectItem(\"" + ma + "\")' id = '" + ma + "check'>";
		reVal += "\n</td>\n";
		reVal += "</tr>\n";
		// display child
		if (!Formater.isNull(treeNode.getListChild()))
			for (int i = 0; i < treeNode.getListChild().size(); i++) {
				iIndent++;
				KtnbTreeNode child = (KtnbTreeNode) ((ArrayList) treeNode.getListChild()).get(i);
				reVal += disPlayNode(child);
				iIndent--;
			}
		iIndent = reIndent;
		return reVal;
	}
}
