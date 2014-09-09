package cmc.com.ktnb.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Variant;
import com.jacob.com.Dispatch;

/**
 * Xử lý xuất file Doc
 * 
 * @author DoHongPhuc
 */
public class MsWordUtils {

	public static final String docin = "\\docin\\";

	public static final String docout = "\\docout\\";

	boolean isVisible = true;

	boolean isSaveOnExit = true;

	ActiveXComponent oWord = null;

	Dispatch oDocuments = null;

	Dispatch oDocument = null;

	// Dispatch oSelection = null;

	// Dispatch oFind = null;

	String fileIn = "";

	String fileOut = "";

	public MsWordUtils() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Khởi tạo
	 * 
	 * @param fileIn :
	 *            Tên file mẫu
	 * @param fileOut :
	 *            Tên file sau khi convert
	 * @throws IOException
	 */
	public MsWordUtils(String fileIn, String fileOut) throws IOException {
		this.fileIn = fileIn;
		this.fileOut = fileOut;
		copyFile(fileIn, fileOut);

		oWord = new ActiveXComponent("Word.Application");
		oWord.setProperty("Visible", new Variant(isVisible));
		oDocuments = oWord.getProperty("Documents").toDispatch();
		oDocument = Dispatch.call(oDocuments, "Open", fileOut).toDispatch();
	}

	/**
	 * Thay text trên file doc
	 * 
	 * @param oldText
	 * @param newText
	 */
	public void put(String oldText, String newText) {
		Dispatch oSelection = oWord.getProperty("Selection").toDispatch();
		Dispatch oFind = Dispatch.call(oSelection, "Find").toDispatch();
		Dispatch.put(oFind, "Text", oldText);
		Dispatch.call(oFind, "Execute");
		Dispatch.put(oSelection, "Text", newText);
		Dispatch.call(oSelection, "MoveUp");
	}
	/**
	 * Đóng tài liệu sau khi replace text xong
	 * 
	 */
	public void saveAndClose() {
		Dispatch oWordBasic = (Dispatch) Dispatch.call(oWord, "WordBasic").getDispatch();
		// Dispatch.call(oWordBasic, "FileSaveAs", this.fileOut);
		Dispatch.call(oDocument, "Close", new Variant(isSaveOnExit));
		oWord.invoke("Quit", new Variant(isSaveOnExit));
	}

	/**
	 * Download file sau khi convert
	 * 
	 * @param fileName:
	 *            Đường dẫn File trả về từ server
	 * @param fileDownloaderName :
	 *            Tên file gửi về client
	 * @param fileType:
	 *            Kiểu file
	 * @param response
	 * @throws Exception
	 */
	public void downloadFile(String fileName, String fileDownloaderName, String fileType, HttpServletResponse response) throws Exception {
		File f = new File(fileName);
		try {
			response.reset();
			response.setHeader("Content-Disposition", "attachment; filename=" + fileDownloaderName + fileType);
			response.addHeader("Cache-Control", "no-store, no-cache");
			response.setContentType("application/msword");			
			byte[] val = getBytesFromFile(f);
			response.setContentLength(val.length);
			response.setBufferSize(val.length);
			response.getOutputStream().write(val);
			response.flushBuffer();
		} catch (Exception ex) {
			System.out.println("=>download file: " + ex.getMessage());
		}finally{
			f.delete();
		}
	}
	public void downloadFile_backup(String fileName, String fileDownloaderName, String fileType, HttpServletResponse response) throws Exception {
		File f = new File(fileName);
		try {
			response.reset();
			response.setHeader("Content-Disposition", "attachment; filename=" + fileDownloaderName + fileType);
			response.addHeader("Cache-Control", "no-store, no-cache");
			response.setContentType("application/msword");			
			byte[] val = getBytesFromFile(f);
			response.setContentLength(val.length);
			response.setBufferSize(val.length);
			response.getOutputStream().write(val);
			response.flushBuffer();
			//f.delete();
		} catch (Exception ex) {
			System.out.println("=>download file: " + ex.getMessage());
		}finally{
			f.delete();
		}
	}

	/**
	 * Convert File to Byte Array
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);

		long length = file.length();

		if (length > Integer.MAX_VALUE) {
			// File is too large
		}

		byte[] bytes = new byte[(int) length];

		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

		if (offset < bytes.length) {
			throw new IOException("Could not completely read file " + file.getName());
		}

		is.close();
		return bytes;
	}

	/**
	 * Copy file doc template to file out
	 * 
	 * @param fromFileName
	 * @param toFileName
	 * @throws IOException
	 */
	public static synchronized void copyFile(String fromFileName, String toFileName) throws IOException {
		File fromFile = new File(fromFileName);
		File toFile = new File(toFileName);

		if (!fromFile.exists())
			throw new IOException("FileCopy: " + "no such source file: " + fromFileName);
		if (!fromFile.isFile())
			throw new IOException("FileCopy: " + "can't copy directory: " + fromFileName);
		if (!fromFile.canRead())
			throw new IOException("FileCopy: " + "source file is unreadable: " + fromFileName);

		if (toFile.isDirectory())
			toFile = new File(toFile, fromFile.getName());

		FileInputStream from = null;
		FileOutputStream to = null;
		try {
			from = new FileInputStream(fromFile);
			to = new FileOutputStream(toFile);
			byte[] buffer = new byte[4096];
			int bytesRead;

			while ((bytesRead = from.read(buffer)) != -1)
			//while ((bytesRead = from.read(buffer)) > 0)
				to.write(buffer, 0, bytesRead);
		} finally {
			if (from != null)
				try {
					from.close();
				} catch (IOException e) {
					;
				}
			if (to != null)
				try {
					to.close();
				} catch (IOException e) {
					;
				}
		}
	}
	
	/**
	 * Create Table tren Document
	 * 
	 * @param tableNumber:
	 *            Vị trí Table trên Document cần xuất ra dữ liệu
	 * @return Dispatch table 
	 */
	public Dispatch openTable(int tableNumber){
		//first table in document. int tableNumber = 2;
		Dispatch table = Dispatch.call(oDocument, "Tables", new Variant(tableNumber)).getDispatch();
		return table;
	}
	
	/**
	 * Add Row vào Table  
	 * 
	 * @param table :
	 *            Table hiện tại 
	 * @param fromRow :
	 *            kiểm soát số lượng row 
	 */
	public void addRowTable(Dispatch table,int fromRow){
		Dispatch rows = Dispatch.call((Dispatch)table, "Rows").getDispatch();
		if(Dispatch.get(rows,"Count").getInt() < fromRow)
			Dispatch.call(rows, "Add");
	}
	
	/**
	 * Add giá trị cho 1 Cell 
	 * 
	 * @param table :
	 *            Table cần xuất ra dữ liệu
	 * @param rowVariant :
	 *            vị trí Row trong table  
	 * @param colVariant:
	 *            vị trí Column trong table 
	 * @param valueCell :
	 * 			  Giá trị của Cell hiện tại(rowVariant,colVariant)
	 */
	public void addCellTable(Dispatch table,int rowVariant,int colVariant,String valueCell){
		Dispatch cell = Dispatch.call((Dispatch)table, "Cell", new Variant(rowVariant), new Variant(colVariant)).getDispatch();
		Dispatch range = Dispatch.call(cell, "Range").getDispatch(); 
		Dispatch.put(range, "Text", valueCell);
	}

}
