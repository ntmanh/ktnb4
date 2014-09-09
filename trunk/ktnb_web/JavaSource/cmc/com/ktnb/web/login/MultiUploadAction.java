package cmc.com.ktnb.web.login;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.web.UploadAction;
import cmc.com.ktnb.web.UploadForm;

public class MultiUploadAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			Object items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			for (int i = 0; i < ((ArrayList) items).size(); i++) {
				FileItem item = (FileItem) ((ArrayList) items).get(i);
				if (!item.isFormField()) {
					File file = new File(UploadAction.UPLOAD_FOLDER + item.getName());
					item.write(file);
				}
			}
		} catch (Exception e) {}
		return mapping.findForward("success");
	}
}
