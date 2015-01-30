package cmc.com.ktnb.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;

import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.DataSourceConfiguration;
import cmc.com.ktnb.util.DetailInformation;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KeyManagement;
import cmc.com.ktnb.util.Table;

public class UploadAction extends Action {
	public static final String UPLOAD_FOLDER = "K:/";
	public static final String UPLOAD_FOLDER_IMGS = "K:/images/";
	public static final String UPLOAD_FOLDER_IMGS_BACKUP = "K:/images_backup/";
	public static final String UPLOAD_FORDER_PDF="K:/Reg_images/";
	
	/*public static final String UPLOAD_FOLDER = "F:/ktnb_file/";
	public static final String UPLOAD_FOLDER_IMGS = "F:/ktnb_file/images/";
	public static final String UPLOAD_FOLDER_IMGS_BACKUP = "F:/ktnb_file/images_backup/";
	public static final String UPLOAD_FORDER_PDF="F:/ktnb_file/Reg_images/";*/
	
	/*public static final String UPLOAD_FOLDER = "D:/ktnb_file/";
	public static final String UPLOAD_FOLDER_IMGS = "D:/ktnb_file/images/";
	public static final String UPLOAD_FOLDER_IMGS_BACKUP = "D:/ktnb_file/images_backup/";
	public static final String UPLOAD_FORDER_PDF="D:/ktnb_file/Reg_images/";*/
	 
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UploadForm f = (UploadForm) form;
		String sql = "", id, forward = "upload";
		if (("post").equals(request.getMethod().toString().toLowerCase())) {
			f.setFormFile((FormFile) form.getMultipartRequestHandler().getFileElements().values().toArray()[0]);
		}
		String method = f.getMethod();
		String parentId = f.getParentId();
		String nVuPath = f.getNv();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String upFolder = UPLOAD_FOLDER;
		try {
			conn = DataSourceConfiguration.getConnection();
			HttpSession session = request.getSession();
			ApplicationContext ac = (ApplicationContext) session.getAttribute(Constants.APP_CONTEXT);
			ActionMessages messages = new ActionMessages();
			//view
			sql = "select ma_file,ten_file,to_char(ngay_cap_nhat,'dd/mm/yy hh24:mi'),so_trang,NGUOI_CAP_NHAT from ktnb_file where ma_don=? and nghiep_vu_path=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, parentId);
			ps.setString(2, nVuPath);
			rs = ps.executeQuery();
			DetailInformation detailInformation;
			Collection c = new ArrayList();
			while (rs.next()) {
				detailInformation = new DetailInformation();
				detailInformation.setCol1(rs.getString(1));
				detailInformation.setCol2(rs.getString(2));
				detailInformation.setCol3(rs.getString(3));
				detailInformation.setCol4(rs.getString(4));
				detailInformation.setCol5(rs.getString(5));
				c.add(detailInformation);
			}
			if (!Formater.isNull(c)) {
				Table table = new Table();
				table.setData(c);
				request.setAttribute("table", table);
			}
			if (!messages.isEmpty())
				saveMessages(request, messages);			
			if ("upload".equals(method)) {
				// CREATE OR REPLACE DIRECTORY KTNB_FILE_DIR AS 'D:\ktnb_file';
				String tenNsd = ac.getTenNsd();
				FormFile formFile = f.getFormFile();
				String fileName = formFile.getFileName();
				//*.gif; *.jpg; *.png;*.docx;*.doc;*.xls;*.xlsx;*.pdf;*.jpeg;*.tif
				if (fileName.toLowerCase().indexOf(".xls".toLowerCase()) < 0 && fileName.toLowerCase().indexOf(".jpeg".toLowerCase()) < 0
						&& fileName.toLowerCase().indexOf(".doc".toLowerCase()) < 0 && fileName.toLowerCase().indexOf(".pdf".toLowerCase()) < 0
						&& fileName.toLowerCase().indexOf(".ppt".toLowerCase()) < 0 && fileName.toLowerCase().indexOf(".jpg".toLowerCase()) < 0
						&& fileName.toLowerCase().indexOf(".bmp".toLowerCase()) < 0 && fileName.toLowerCase().indexOf(".tif".toLowerCase()) < 0
						&& fileName.toLowerCase().indexOf(".gif".toLowerCase()) < 0 && fileName.toLowerCase().indexOf(".png".toLowerCase()) < 0)
					throw new Exception("Sai định dạng file! Bạn phải chọn file văn bản hoặc ảnh để gửi lên.");
				String contentType = formFile.getContentType();
				String page = f.getPage();
				if (Formater.isNull(page))
					page = "1";
				FileOutputStream fileOutputStream = null;
				FileOutputStream fileOutputStreamBackup = null;
				if (isImageFile(fileName)) {
					id = KeyManagement.GUID(ac) + fileName;
					//Upload to Image
					File fcheck = new File(UPLOAD_FOLDER_IMGS + id);
					if (!fcheck.exists()) {
						fcheck.createNewFile();
					}
					fileOutputStream = new FileOutputStream(UPLOAD_FOLDER_IMGS + id);
					fileOutputStream.write(formFile.getFileData());
					fileOutputStream.close();
					//Create backup Images file
					File fBackupcheck = new File(UPLOAD_FOLDER_IMGS_BACKUP + id);
					//tạo folder chưa file backup nếu trên server chưa có
					File theDir = new File(UPLOAD_FOLDER_IMGS_BACKUP);
					if (!theDir.exists()) {
						theDir.mkdir();
					}
					if (!fBackupcheck.exists()) {
						fBackupcheck.createNewFile();
					}
					fileOutputStreamBackup = new FileOutputStream(UPLOAD_FOLDER_IMGS_BACKUP + id);
					fileOutputStreamBackup.write(formFile.getFileData());
					fileOutputStreamBackup.close();
					
					sql = "insert into ktnb_file (MA_FILE,MA_DON,TEN_FILE,LOAI_FILE,SO_TRANG,NGUOI_CAP_NHAT,NOI_DUNG,NGHIEP_VU_PATH) values (?,?,?,?,?,?,BFILENAME('KTNB_FILE_DIR_IMGS','" + id + "'),?)";
				} else {
					id = KeyManagement.GUID(ac);
					File fcheck = new File(UPLOAD_FOLDER + id);
				
					if (!fcheck.exists()) 
						fcheck.createNewFile();					
					fileOutputStream = new FileOutputStream(UPLOAD_FOLDER +  id);
					fileOutputStream.write(formFile.getFileData());
					fileOutputStream.close();
					sql = "insert into ktnb_file (MA_FILE,MA_DON,TEN_FILE,LOAI_FILE,SO_TRANG,NGUOI_CAP_NHAT,NOI_DUNG,NGHIEP_VU_PATH) values (?,?,?,?,?,?,BFILENAME('KTNB_FILE_DIR','" + id + "'),?)";
				}
				// insert to DB
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, parentId);
				ps.setString(3, fileName);
				ps.setString(4, contentType);
				ps.setString(5, page);
				ps.setString(6, tenNsd);
				ps.setString(7, nVuPath);
				ps.executeUpdate();
				formFile.destroy();
				messages.add("message", new ActionMessage("error.message", "Gửi file thành công!"));
			} else if ("delete".equals(method)) {
				id = f.getId();
				boolean success = (new File(UPLOAD_FOLDER + id)).delete();
				if (!success)
					messages.add("message", new ActionMessage("error.message", "Không xóa được file"));
				sql = "delete ktnb_file where MA_FILE=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.executeUpdate();
				messages.add("message", new ActionMessage("error.message", "Xóa file thành công!"));
			} else if ("download".equals(method)) {
				id = f.getId();				
//				sql = "select TEN_FILE,LOAI_FILE,NOI_DUNG from ktnb_file where MA_FILE=?";
				sql = "select TEN_FILE,LOAI_FILE from ktnb_file where MA_FILE=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				
				if (rs.next()) {
					String fileName = rs.getString(1);
					if (isImageFile(fileName))
					{
						//upFolder=UPLOAD_FOLDER_IMGS;
						try {
							upFolder=UPLOAD_FORDER_PDF;
							String fileFDF = id.split("\\.")[0]+ ".pdf";
							InputStream inputStream = new FileInputStream(upFolder+fileFDF);
							byte[] buffer = new byte[1024];
							int nbytes = 0;
							response.reset();
							response.setContentType("application/pdf");
							response.setHeader("Cache-Control", "max-age=0");
							response.setHeader("Content-Disposition", "attachment;filename=" + fileName.split("\\.")[0]+ ".pdf");
							OutputStream outputStream = response.getOutputStream();
							while ((nbytes = inputStream.read(buffer)) != -1)
							outputStream.write(buffer, 0, nbytes);
							outputStream.flush();
							outputStream.close();
							inputStream.close();
							return null;
						} catch (FileNotFoundException e) {
							upFolder=UPLOAD_FOLDER_IMGS;
							//strParam+="."+fileName.split("\\.")[1];
						}
					}
					String contentType = rs.getString(2);
					//BFILE bfile = (BFILE) rs.getObject(3);
					//System.out.println("exist = " + bfile.fileExists() + "; dir= " + bfile.getDirAlias() + "; name= " + bfile.getName());
					//bfile.openFile();
					InputStream inputStream = new FileInputStream(upFolder+id);
					byte[] buffer = new byte[1024];
					int nbytes = 0;
					response.reset();
					response.setContentType(contentType);
					response.setHeader("Cache-Control", "max-age=0");
					response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
					OutputStream outputStream = response.getOutputStream();
					while ((nbytes = inputStream.read(buffer)) != -1)
						outputStream.write(buffer, 0, nbytes);
					outputStream.flush();
					outputStream.close();
					inputStream.close();
					//bfile.closeFile();
					return null;
				} else
					messages.add("message", new ActionMessage("error.message", "File not found!"));
			} else if (method != null && method.indexOf("downLoad") >= 0) {
				// id = request.getParameter("id");
				String strParam = "";
				if ("downLoadVbXinHoan".equals(method)) {
					sql = "select TEN_FILE_VB_XIN_HOAN TEN_FILE, LOAI_FILE_VB_XIN_HOAN LOAI_FILE, VB_XIN_HOAN_CUA_DV_DUOC_TTKT NOI_DUNG from TTKT_CB_HOAN where ID_CUOC_TTKT=?";
					strParam = request.getParameter("idCuocTtKt");

				} else if ("downLoadVbTraLoiHoan".equals(method)) {
					sql = "select TEN_FILE_VB_TRA_LOI_HOAN TEN_FILE, LOAI_FILE_VB_TRA_LOI_HOAN LOAI_FILE, VB_TRA_LOI_CUA_DV_TH NOI_DUNG from TTKT_CB_HOAN where ID_CUOC_TTKT=?";
					strParam = request.getParameter("idCuocTtKt");

				} else if ("downLoadVbThongBaoHoan".equals(method)) {
					sql = "select TEN_FILE_THONG_BAO_HOAN TEN_FILE, LOAI_FILE_THONG_BAO_HOAN LOAI_FILE, VB_THONG_BAO_HOAN NOI_DUNG from TTKT_CB_HOAN where ID_CUOC_TTKT=?";
					strParam = request.getParameter("idCuocTtKt");

				} else if ("downLoadFileById".equals(method)) {
					sql = "select TEN_FILE,LOAI_FILE,NOI_DUNG from ktnb_file where MA_FILE=?";
					strParam = request.getParameter("ma_file");

				} else if ("downLoadKeHoachTtkt".equals(method)) {
					strParam = request.getParameter("ma_file");
					sql = "select TEN_FILE,LOAI_FILE,BFILENAME('KTNB_FILE_DIR','" + strParam + "') as NOI_DUNG from TTKT_CB_KH_TTKT where MA_FILE=?";

				} else if ("downLoadBienBan".equals(method)) {
					strParam = request.getParameter("ma_file");
					sql = "select FILE_DINH_KEM NOI_DUNG,TEN_FILE TEN_FILE,LOAI_FILE LOAI_FILE from TTKT_TH_BB_CHITIETVATONGHOP where id=?";
				} else if ("downLoadDeCuongTtkt".equals(method)) {
					strParam = request.getParameter("ma_file");
					sql = "select t.ten_file, t.loai_file, BFILENAME('KTNB_FILE_DIR',t.ma_file) noi_dung from ttkt_cb_de_cuong t where t.ma_file=?";
				}else if("downLoadYeuCauGiaiTrinh".equals(method)){
					strParam = request.getParameter("ma_file");
					sql = "select TEN_FILE,LOAI_FILE from TTKT_TH_YEU_CAU_GIAI_TRINH where ID=?";
				}else if("downLoadKetLuanChuyenBaoCao".equals(method)){
					strParam = request.getParameter("ma_file");
					sql = "select BFILENAME('KTNB_FILE_DIR','" + strParam + "') as NOI_DUNG, TEN_FILE,LOAI_FILE from TTKT_TH_BB_CHITIETVATONGHOP where ID=?";
				}
				ps = conn.prepareStatement(sql);
				ps.setString(1, strParam);
				rs = ps.executeQuery();
				if (rs.next()) {
					String fileName = URLEncoder.encode(rs.getString("TEN_FILE"),"UTF-8");
					String contentType = rs.getString("LOAI_FILE");
					if (isImageFile(fileName))
					{
						try {
							upFolder=UPLOAD_FORDER_PDF;
							String fileID = strParam+ ".pdf";
							InputStream inputStream = new FileInputStream(upFolder+fileID);
							byte[] buffer = new byte[1024];
							int nbytes = 0;
							response.reset();
							response.setContentType("application/pdf");
							response.setHeader("Cache-Control", "max-age=0");
							response.setHeader("Content-Disposition", "attachment;filename=" + fileName.split("\\.")[0]+".pdf");
							OutputStream outputStream = response.getOutputStream();
							while ((nbytes = inputStream.read(buffer)) != -1)
							outputStream.write(buffer, 0, nbytes);
							outputStream.flush();
							outputStream.close();
							inputStream.close();
							return null;
						} catch (FileNotFoundException e) {
							upFolder=UPLOAD_FOLDER_IMGS;
							strParam+="."+fileName.split("\\.")[1];
						}
						
					}
					//BFILE bfile = (BFILE) rs.getObject("NOI_DUNG");
					//bfile.openFile();
					InputStream inputStream = new FileInputStream(upFolder+strParam);
					byte[] buffer = new byte[1024];
					int nbytes = 0;
					response.reset();
					response.setContentType(contentType);
					response.setHeader("Cache-Control", "max-age=0");
					response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
					OutputStream outputStream = response.getOutputStream();
					while ((nbytes = inputStream.read(buffer)) != -1)
						outputStream.write(buffer, 0, nbytes);
					outputStream.flush();
					outputStream.close();
					inputStream.close();
					//bfile.closeFile();
				}
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			f.setMethod(null);
			f.setId(null);
			DataSourceConfiguration.releaseSqlResources(rs, ps, conn);
		}
		return mapping.findForward(forward);
	}
	public static boolean isImageFile(String fileName)
	{
		if (fileName.toLowerCase().indexOf(".jpg".toLowerCase()) != -1 || fileName.toLowerCase().indexOf(".bmp".toLowerCase()) != -1
				|| fileName.toLowerCase().indexOf(".tif".toLowerCase()) != -1 || fileName.toLowerCase().indexOf(".gif".toLowerCase()) != -1
				|| fileName.toLowerCase().indexOf(".png".toLowerCase()) != -1|| fileName.toLowerCase().indexOf(".jpeg".toLowerCase()) != -1)
			return true;
		else
			return false;
	}
	public static void saveFile(FormFile formFile,String id){
		//check input
		if(formFile==null||Formater.isNull(id))
		{
			return;
		}
		String uploadForder="";
		String fileName = formFile.getFileName();
		if (UploadAction.isImageFile(fileName)){
			uploadForder= UPLOAD_FOLDER_IMGS;
			id+="."+fileName.split("\\.")[1];
		}else{
			uploadForder = UPLOAD_FOLDER;
		}

		try {
			File fcheck = new File(uploadForder + id);
			if (!fcheck.exists()) {
				fcheck.createNewFile();
			}
			FileOutputStream fileOutputStream = new FileOutputStream(uploadForder + id);
			fileOutputStream.write(formFile.getFileData());
			fileOutputStream.close();
			formFile.destroy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void deleteFile(String id){
		try{
			(new File(UploadAction.UPLOAD_FOLDER + id)).delete();
		}catch(Exception ex){
		}	
		try{
			(new File(UploadAction.UPLOAD_FOLDER_IMGS + id)).delete();
		}catch(Exception ex){
		}
	}
}
