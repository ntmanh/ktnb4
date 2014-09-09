package cmc.com.ktnb.web;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRMapArrayDataSource;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRCsvExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import cmc.com.ktnb.util.ApplicationContext;
import cmc.com.ktnb.util.Constants;
import cmc.com.ktnb.util.Formater;
import cmc.com.ktnb.util.KtnbUtil;
public class ReportAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			long start = System.currentTimeMillis();
			HttpSession session = request.getSession();
			ApplicationContext ac = (ApplicationContext) session.getAttribute(Constants.APP_CONTEXT);
			String systemDate = Formater.date2str(ac.getSystemDate());
			String[] arr = Formater.split(systemDate, "/");
			String ten_phong = ac.getTenPhong();
			String ten_cqt = ac.getTenCqt();
			String ma_cqt = ac.getMaCqt();
			String ten_tinh = KtnbUtil.getTenTinhByMaCqt(ac,ma_cqt);
			Map parameters = new HashMap();
			parameters.put("ten_cqt", ten_cqt);
			parameters.put("ten_phong", ten_phong);
			String rp = (String) request.getParameter("rp");
			String format = (String) request.getParameter("format");
			if (Formater.isNull(format))
				format = "PDF";
			if (Formater.isNull(rp))
				rp = "ttnb04";
			HashMap[] reportRows = null;
			HashMap row;
			StringBuffer sb;
			if ("ttnb12".equals(rp)) { // Ke hoach Ttkt

			} else if ("ttnb13".equals(rp)) { // De cuong

			} else if ("bienBanHopDoanTrienKhai".equals(rp)) { // Hop doan trien khai, mau so 14

			} else if ("ttnb16".equals(rp)) { // Cong bo quyet dinh

			} 
			
			else if ("ttnb17".equals(rp)) { // Phieu Yeu Cau (Yeu cau bo sung tai lieu)

			}
			else if ("ttnb18".equals(rp)) { // Bien ban giao nhan (Yeu cau bo sung tai lieu)

						}
			else if ("ttnb19".equals(rp)) { // Bien ban giao tra (Yeu cau bo sung tai lieu)

						}
			else if ("ttnb32".equals(rp)) { // Bien ban Trung cau giam dinh

								}
			else if ("ttnb10".equals(rp)) { // in to trinh gia han ttkt

											}
			else if ("ttnb11".equals(rp)) { // in quyet dinh gia han ttkt

											}
			else if ("ttnb28".equals(rp)) { // in pieu yeu cau - yeu cau giai trinh

											}
			else if ("ttnb20".equals(rp)) { // in bien ban lam viec(ket thuc ttkt)

														}
			else if ("ttnb39".equals(rp)) { // in bien ban cong bo ket luan

														}
			else if ("ttnb40".equals(rp)) { // in van ban - chuyen giao hstl sang co quan dien tra
			}
			else if ("ttnb41".equals(rp)) { // in bien ban - chuyen giao hstl sang co quan dien tra
			}
			else if ("ttnb15".equals(rp)) { // Nhat ky ttkt
			} else if ("banGiaoHstlChoTruongDoan".equals(rp)) { // Ban giao ho so tai lieu cho truong doan, mau so 18

			} else if ("ttnb35".equals(rp)) { // Thong bao ket thuc
			} else if ("hopRutKinhNghiemDoan".equals(rp)) { // Hop rut kinh nghiem doan, mau so 14

			} else if ("banGiaoHoSoLuuTru".equals(rp)) { // Ban gio ho so luu tru, mau so 18

			} else if ("ttnb04".equals(rp)) {
				String ma_dv = (String) request.getParameter("ma_dv");
				if (Formater.isNull(ma_dv)) {
					ma_dv = "10100";
				}
				String ten_dv = KtnbUtil.getTenCqtByMa(ma_dv);
				String loai_nv = (String) request.getParameter("loai_nv");
				String ten_nv = ("0".equals(loai_nv)) ? "thanh tra" : "ki\u1EC3m tra";
				parameters.put("ten_bc", "T\u1EDC TR\u00CCNH");
				parameters.put("ngay_trinh", ten_tinh + ", " + "Ng\u00E0y " + arr[0] + " Th\u00E1ng " + arr[1] + " N\u0103m " + arr[2]);
				parameters.put("ngay_duyet", ten_tinh + ", " + "Ng\u00E0y.....Th\u00E1ng.....N\u0103m " + arr[2]);
				//ve_viec
				sb = new StringBuffer("V/v \u0110\u1EC1 ngh\u1ECB nh\u00E2n s\u1EF1 \u0110o\u00E0n ");
				sb.append(ten_nv);
				sb.append(" n\u1ED9i b\u1ED9 t\u1EA1i ");
				sb.append(ten_dv);
				sb.append(".");
				parameters.put("ve_viec", sb.toString());

				//kinh_gui
				String ten_ld = KtnbUtil.getLanhDaoByMaCqt(ma_dv);
				if (Formater.isNull(ten_ld))
					ten_ld = " L\u00E3nh \u0111\u1EA1o " + ten_cqt;
				else
					ten_ld = " \u0110/c " + ten_ld;
				parameters.put("kinh_gui", "K\u00EDnh g\u1EEDi : " + ten_ld + ".");

				//can_cu
				sb = new StringBuffer("C\u0103n c\u1EE9 k\u1EBF ho\u1EA1ch thanh tra, ki\u1EC3m tra n\u1ED9i b\u1ED9 n\u0103m ");
				sb.append(arr[2]);

				sb.append(".\nC\u0103n c\u1EE9.\n");
				sb.append(ten_phong);
				sb.append(" tr\u00ECnh ");
				sb.append(ten_ld);
				sb.append(" th\u00E0nh ph\u1EA7n \u0111o\u00E0n \u0111\u1EC3 ");
				sb.append(ten_nv);
				sb.append(" t\u1EA1i ");
				sb.append(ten_dv);
				sb.append(" nh\u01B0 sau:");
				parameters.put("can_cu", sb.toString());

				//phe_duyet
				sb = new StringBuffer("Tr\u00ECnh ");
				sb.append(ten_ld);
				sb.append(" xem x\u00E9t, ph\u00EA duy\u1EC7t./.");
				parameters.put("phe_duyet", sb.toString());

				reportRows = new HashMap[5];
				for (int i = 0; i < 5; i++) {
					row = new HashMap();
					row.put("ten_thanh_vien", (i + 1) + ". \u00D4ng (b\u00E0): Nguy\u1EC5n Kh\u1ED5ng " + i);
					row.put("chuc_vu", " - Tr\u01B0\u1EDFng ph\u00F2ng");
					reportRows[i] = row;
				}
			}
			JRMapArrayDataSource dataSource = new JRMapArrayDataSource(reportRows);
			InputStream inputStream = getServlet().getServletContext().getResourceAsStream("/report/" + rp + ".jasper");
			JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parameters, dataSource);
			response.reset();
			ServletOutputStream servletOutputStream = response.getOutputStream();
			response.addHeader("Content-Disposition", "attachment;filename=" + rp + "." + format);
			if ("PDF".equals(format)) {
				response.setContentType("application/pdf");
				JRPdfExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRPdfExporterParameter.CHARACTER_ENCODING, "UTF-8");
				exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, servletOutputStream);
				exporter.exportReport();
			} else if ("XLS".equals(format)) {
				response.setContentType("application/vnd.ms-excel");
				//JRXlsExporter exporter=new JRXlsExporter();
				JExcelApiExporter exporter = new JExcelApiExporter();
				exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, servletOutputStream);
				exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
				exporter.exportReport();
			} else if ("XLSX".equals(format)) {
				response.setContentType("application/vnd.ms-excel");
			} else if ("CSV".equals(format)) {
				response.setContentType("application/csv");
				servletOutputStream.write(new byte[] {(byte) 0xFF, (byte) 0xFE });
				JRCsvExporter exporter = new JRCsvExporter();
				exporter.setParameter(JRCsvExporterParameter.CHARACTER_ENCODING, "UnicodeLittleUnmarked");
				exporter.setParameter(JRCsvExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRCsvExporterParameter.OUTPUT_STREAM, servletOutputStream);
				exporter.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, "\t");
				exporter.exportReport();
			} else if ("RTF".equals(format)) {
				response.setContentType("application/rtf");
			} else if ("DOCX".equals(format)) {
				response.setContentType("application/docx");
			}
			servletOutputStream.flush();
			servletOutputStream.close();
			System.out.println("Report time=" + (System.currentTimeMillis() - start));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}