package cmc.com.ktnb.web;

import org.apache.struts.upload.FormFile;

public class UploadForm  extends org.apache.struts.action.ActionForm 
{
	private String id;
	private String method;
	private String parentId;
	private String nv;
	private FormFile formFile;
	private String page="1";
	

	public void setId(String id) {
		this.id = id;
	}


	public String getId() {
		return id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String string) {
		parentId = string;
	}


	
	

	/**
	 * @return
	 */
	public FormFile getFormFile() {
		return formFile;
	}

	/**
	 * @return
	 */
	public String getPage() {
		return page;
	}

	/**
	 * @param file
	 */
	public void setFormFile(FormFile file) {
		formFile = file;
	}

	/**
	 * @param string
	 */
	public void setPage(String string) {
		page = string;
	}

	/**
	 * @return
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param string
	 */
	public void setMethod(String string) {
		method = string;
	}


	public String getNv() {
		return nv;
	}


	public void setNv(String vuPath) {
		nv = vuPath;
	}
}
