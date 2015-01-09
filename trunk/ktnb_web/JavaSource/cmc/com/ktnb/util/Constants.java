package cmc.com.ktnb.util;

public class Constants {
	//Dùng BTC hay KTNB
	public static final String USE_BTC = "0";//=1 Dùng BTC, =0 Dùng KTNB
	// Loại kết thúc hồ sơ
	public static final String KNTC_KET_THUC_THUONG = "0";
	public final static String KNTC_KET_THUC_GOP_DON = "1";//Gộp đơn cho trường hợp hồ sơ gốc đang xử lý
	public final static String KNTC_KET_THUC_RUT_DON = "2"; //Rut/Dong Don
	public final static String KNTC_KET_THUC_TRA_DON = "3";
	public final static String KNTC_KET_THUC_CHUYEN_DON = "4";
	public final static String KNTC_KET_THUC_TACH_DON = "5";
	public final static String KNTC_KET_THUC_LUU_DON = "6";//Lưu đơn cho trường hợp hồ sơ gốc đã kết thúc
	public final static String KNTC_KET_THUC_XOA_HS = "7";//Hồ sơ xóa

	// Loại liên kết hồ sơ
	public static final String LIEN_KET_CHA = "0"; // (Tách đơn thành 2 đơn KH-TC)
	public static final String LIEN_KET_GOP = "1"; // (Gộp 2 đơn cùng 1 vụ việc) dùng cho gộp đơn, lưu đơn
	public static final String LIEN_KET_CHUYEN = "2"; // (Chuyển đơn cho cơ quan cấp dưới)
	
	//Role chức vụ
	public static final String LANH_DAO_TCT = "'1125','1129'"; // Tong cuc Truong, TCP

	public static final String LANH_DAO_CT = "'1105','1107'"; // Cuc truong, pho cuc truong

	public static final String LANH_DAO_CCT = "'1109','1111'"; // Chi cuc truong, Pho chi cuc truong

	public static final String LANH_DAO = "2402"; // Role lanh dao

	public static final String TRUONG_PHONG_KNTC = "2413"; // Role lanh dao

	/**
	 * Bo sung
	 */
	public final static String TTKT_SUA_ADD = "B\u1ED5 sung";

	/**
	 * Sua
	 */
	public final static String TTKT_SUA_EDIT = "S\u1EEDa";

	/**
	 * Xoa
	 */
	public final static String TTKT_SUA_DEL = "X\u00F3a";

	// Loai cuoc ttkt trong ke hoach nam
	/**
	 * Ke hoach nam
	 */
	public final static String TTKT_LOAI_KHN_KH = "KHN";

	/**
	 * Bo sung ke hoach nam
	 */
	public final static String TTKT_LOAI_KHN_ADD = "BS";

	/**
	 * Sua cuoc trong ke hoach
	 */
	public final static String TTKT_LOAI_KHN_EDIT = "S\u1EEDa";

	/**
	 * Cuoc bo sung do sua ke hoach
	 */
	public final static String TTKT_LOAI_KHN_ADD_BY_EDIT = "TD";

	/**
	 * Bi thay doi trong quyet dinh
	 */
	public final static String TTKT_LOAI_KHN_CHANGE_IN_QD = "TDTQD";

	/**
	 * Cuoc bi xoa khi chinh sua ke hoach
	 */
	public final static String TTKT_LOAI_KHN_DEL = "X\u00F3a";

	// Loai cuoc ttkt trong quyet dinh
	/**
	 * Cuoc bi sua khi ra quyet dinh
	 */
	public final static String TTKT_LOAI_QD_EDIT = "S\u1EEDa";

	/**
	 * Cuoc bo sung do sua khi ra quyet dinh
	 */
	public final static String TTKT_LOAI_QD_ADD_BY_EDIT = "S\u1EEDa";

	public final static String TATCA = "T\u1EA5t c\u1EA3";

	public final static String TCT_CODE = "00000";

	public final static String DM_TTKT = "10";

	public final static String DM_CHUC_VU = "11";

	public final static String APP_CONTEXT = "application_context";
	
	public final static int VERSION_APP = 69;
	
	public final static String DBNAME = "jdbc/ktnbDS";
	public final static String DBNAME_BTC = "jdbc/btcDS";

	public final static int PAGE_SIZE = 10;

	public final static Integer PAGE_SIZE_DEFAULT = new Integer(10);

	public final static Integer MAX_PAGE_DEFAULT = new Integer(5);

	public final static String UPDATE = "U";

	public final static String INSERT = "I";

	public final static String DELETE = "D";

	public final static String EXIT = "exit";

	public final static String FALSE = "false";

	public final static String TRUE = "true";

	public final static String CHECK_RIGHT = "checkRight";

	public final static String CHECK_UPDATE_DATA = "checkUpdateData";

	public final static String CHECK_INSERT_DATA = "checkInsertData";

	public final static String CHECK_DELETE_DATA = "checkDeleteData";

	public final static String CHECK_CHANGE_DATA = "checkChangeData";

	public final static String checkIsTCT = "isTCT";

	public final static String isTCT = "true";

	public final static String isNotTCT = "false";

	public final static String IS_CHI_CUC = "isChiCuc";

	// Trang thai cuoc Ttkt
	public final static String TT_TTKT_CREATE = "Ch\u01B0a th\u1EF1c hi\u1EC7n";

	/**
	 * Het hieu luc
	 */
	public final static String TT_TTKT_HET_HL = "H\u1EBFt hi\u1EC7u l\u1EF1c";

	public final static String TT_TTKT_CDTD = "Ch\u1EC9 \u0111\u1ECBnh tr\u01B0\u1EDFng \u0111o\u00E0n";

	/**
	 * Bao cao khao sat
	 */
	public final static String TT_TTKT_BCKS = "B\u00E1o c\u00E1o kh\u1EA3o s\u00E1t";

	/**
	 * Chi dinh thanh vien doan
	 */
	public final static String TT_TTKT_CDTVD = "Ch\u1EC9 \u0111\u1ECBnh th\u00E0nh vi\u00EAn \u0111o\u00E0n";

	/**
	 * Quyet dinh
	 */
	public final static String TT_TTKT_QD = "Quy\u1EBFt \u0111\u1ECBnh";

	/**
	 * Lap ke hoach
	 */
	public final static String TT_TTKT_KH = "L\u1EADp k\u1EBF ho\u1EA1ch";

	/**
	 * Lap de cuong
	 */
	public final static String TT_TTKT_DC = "L\u1EADp \u0111\u1EC1 c\u01B0\u01A1ng";

	/**
	 * Hop doan trien khai
	 */
	public final static String TT_TTKT_HOP = "H\u1ECDp \u0111o\u00E0n tri\u1EC3n khai";

	/**
	 * Huy
	 */
	public final static String TT_TTKT_HUY = "H\u1EE7y";

	/**
	 * Hoan
	 */
	public final static String TT_TTKT_HOAN = "Ho\u00E3n";

	/**
	 * Chuan bi tien hanh
	 */
	public final static String TT_TTKT_CBTH = "Chu\u1EA9n b\u1ECB ti\u1EBFn h\u00E0nh";

	/**
	 * Cong bo quyet dinh
	 */
	public final static String TT_TTKT_CBQD = "C\u00F4ng b\u1ED1 quy\u1EBFt \u0111\u1ECBnh";

	public final static String TT_TTKT_NK = "L\u1EADp nh\u1EADt k\u00FD";

	/**
	 * Bien ban chi tiet
	 */
	public final static String TT_TTKT_BBCT = "Bi\u00EAn b\u1EA3n chi ti\u1EBFt";

	/**
	 * Ban giao ho so luu tru
	 */
	public final static String TT_TTKT_BGHSLT = "B\u00E0n giao, l\u01B0u tr\u1EEF h\u1ED3 s\u01A1";

	/**
	 * Chuyen du lieu sang bao cao
	 */
	public final static String TT_TTKT_CDLBC = "Chuy\u1EC3n d\u1EEF li\u1EC7u sang b\u00E1o c\u00E1o";

	/**
	 * Ban giao ho so tai lieu cho truong doan
	 */
	public final static String TT_TTKT_BGHSTLCTD = "B\u00E0n giao hstl cho tr\u01B0\u1EDFng \u0111o\u00E0n";

	/**
	 * Du thao bien ban tong hop
	 */
	public final static String TT_TTKT_DTBBTH = "D\u1EF1 th\u1EA3o bi\u00EAn b\u1EA3n t\u1ED5ng h\u1EE3p";

	/**
	 * Bien ban tong hop gui don vi duoc Ttkt
	 */
	public final static String TT_TTKT_BBTHGDVTTKT = "Bb t\u1ED5ng h\u1EE3p g\u1EEDi dvi \u0111\u01B0\u1EE3c Ttkt";

	/**
	 * Bien ban tong hop gui don vi duoc Ttkt - y kien dong gop cua don vi dc
	 * ttkt
	 */
	public final static String TT_TTKT_BBTHGDVTTKT_YK = "\u00DD ki\u1EBFn c\u1EE7a \u0111\u01A1n v\u1ECB \u0111\u01B0\u1EE3c ttkt";

	/**
	 * Lap bien ban tong hop
	 */
	public final static String TT_TTKT_BBTH = "L\u1EADp bi\u00EAn b\u1EA3n t\u1ED5ng h\u1EE3p";

	/**
	 * Tien hanh
	 */
	public final static String TT_TTKT_TH = "Ti\u1EBFn h\u00E0nh";

	/**
	 * Thong bao ket thuc
	 */
	public final static String TT_TTKT_TBKT = "Th\u00F4ng b\u00E1o k\u1EBFt th\u00FAc";

	/**
	 * Du thao ket qua
	 */
	public final static String TT_TTKT_DTKQ = "D\u1EF1 th\u1EA3o k\u1EBFt qu\u1EA3";

	/**
	 * Du thao ket luan
	 */
	public final static String TT_TTKT_DTKL = "D\u1EF1 th\u1EA3o k\u1EBFt lu\u1EADn";

	/**
	 * Ket luan
	 */
	public final static String TT_TTKT_KL = "K\u1EBFt lu\u1EADn";

	public final static String TT_TTKT_BBGIAOTRA_YCBSTL = "YCBSTL/GT";

	public final static String TT_TTKT_BBGIAONHAN_YCBSTL = "YCBSTL/GN";

	public final static String TT_TTKT_HOPRKN = "H\u1ECDp r\u00FAt kinh nghi\u1EC7m \u0111o\u00E0n";

	public final static String TT_TTKT_KQ = "K\u1EBFt qu\u1EA3";

	public final static String TT_TTKT_KT = "K\u1EBFt th\u00FAc";

	public final static String[] ARR_TRANG_THAI_CUOC_TTKT = new String[] { TT_TTKT_CREATE, 
		TT_TTKT_CDTD, TT_TTKT_BCKS, TT_TTKT_CDTVD, 
		TT_TTKT_QD, TT_TTKT_KH, TT_TTKT_DC, 
		TT_TTKT_HOP, TT_TTKT_CBQD, TT_TTKT_NK, 
		TT_TTKT_BBCT, TT_TTKT_BGHSTLCTD, TT_TTKT_DTBBTH, 
		TT_TTKT_BBTHGDVTTKT, TT_TTKT_BBTH,
		TT_TTKT_TBKT, TT_TTKT_DTKQ, TT_TTKT_KQ, TT_TTKT_DTKL, 
		TT_TTKT_KL, TT_TTKT_HOPRKN, TT_TTKT_BGHSLT, TT_TTKT_CDLBC, TT_TTKT_KT };

	// Chuc vu trong doan
	public final static String TTKT_CVTD_TD = "Truong doan";

	public final static String TTKT_CVTD_PD = "Pho doan";

	public final static String TTKT_CVTD_TVD = "Thanh vien doan";

	public final static String CHANGE_INSERT = "Insert";

	public final static String CHANGE_UPDATE = "Update";

	public final static String CHANGE_DELETE = "Delete";

	// Cac bien ban Ttkt
	/**
	 * Hop doan trien khai
	 */
	public final static String TTKT_BB_HDTK = "Hop doan trien khai";

	/**
	 * To chuc hoi thoai chat van
	 */
	public final static String TTKT_BB_HTCV = "T\u1ED5 ch\u1EE9c h\u1ED9i tho\u1EA1i ch\u1EA5t v\u1EA5n";

	/**
	 * Lam viec voi don vi, bo phan, to chuc, ca nhan, lien quan
	 */
	public final static String TTKT_BB_LVVCBLQ = "L\u00E0m vi\u1EC7c v\u1EDBi c\u01A1 quan, \u0111\u01A1n v\u1ECB, b\u1ED9 ph\u1EADn, c\u00E1 nh\u00E2n";

	/**
	 * Lam viec voi cong chuc, vien chuc, quan chung
	 */
	public final static String TTKT_BB_LVVCNVCQC = "L\u00E0m vi\u1EC7c v\u1EDBi c\u00F4ng ch\u1EE9c, vi\u00EAn ch\u1EE9c v\u00E0 qu\u1EA7n ch\u00FAng";

	/**
	 * Hop rut kinh nghiem
	 */
	public final static String TTKT_BB_HRKN = "Hop rut kinh nghiem";

	/**
	 * Bien ban chi tiet
	 */
	public final static String TTKT_BB_CT = "Bien ban chi tiet";

	/**
	 * Du thao bien ban tong hop
	 */
	public final static String TTKT_BB_DTTH = "Du thao Bb tong hop";

	/**
	 * Du thao ket qua
	 */
	public final static String TTKT_BB_DTKQ = "Du thao ket qua";

	/**
	 * Ket qua
	 */
	public final static String TTKT_BB_KQ = "Ket qua";

	/**
	 * Du thao ket luan
	 */
	public final static String TTKT_BB_DTKL = "Du thao ket luan";

	/**
	 * Ket luan
	 */
	public final static String TTKT_BB_KL = "Ket luan";

	/**
	 * Bien ban tong hop gui don vi duoc Thanh tra Kiem tra
	 */
	public final static String TTKT_BB_THGDV = "Bien ban tong hop gui dv duoc ttkt";

	/**
	 * Ban giao ho so luu tru
	 */
	public final static String TTKT_BB_BGHSLT = "Ban giao ho so luu tru";

	/**
	 * Bien ban tong hop
	 */
	public final static String TTKT_BB_TH = "Bien ban tong hop";

	/**
	 * Bien ban hop to chuc thong bao ket thuc voi don vi duoc ttkt
	 */
	public final static String TTKT_BB_TBKT = "Bien ban to chuc thong bao ket thuc voi don vi duoc ttkt";

	/**
	 * Bien ban tong hop:To chuc thong qua voi don vi duoc ttkt
	 */
	public final static String TTKT_BB_TCTQ = "To chuc thong qua voi don vi duoc ttkt";

	/**
	 * Bien ban tong hop:Cham thong qua
	 */
	public final static String TTKT_BB_CTQ = "Cham thong qua";

	// Loai Ho so tai lieu
	public final static String TTKT_LOAI_HSTL_HSTL = "Ho so tai lieu";

	public final static String TTKT_LOAI_HSTL_BC = "Bao cao";

	// Nghiep vu path (duong dan toi file dinh kem)
	public final static String TTKT_NV_BCKS = "TTKT/BCKS";

	// Loai nhan tra ho so tai lieu
	/**
	 * Ban giao ho so luu tru
	 */
	public static final String TTKT_GNH_BGHSLT = "Ban giao ho so luu tru";

	// Danh muc Phan loai xu ly don khieu nai trong qua trinh tiep dan

	// Danh muc Phan loai xu ly don khieu nai trong qua trinh xu ly
	public final static String PLXL_DON_KN = "150201";

	public final static String PLXL_DON_KN_THUOC_THAM_QUYEN_CO_QUAN_THUE_NHAN_DON = "15020101";

	public final static String PLXL_DON_KN_KHONG_THUOC_THAM_QUYEN_CO_QUAN_THUE_NHAN_DON = "15020102";

	public final static String PLXL_DON_KN_MOT_PHAN_THUOC_THAM_QUYEN_CO_QUAN_THUE_NHAN_DON = "15020103";

	public final static String PLXL_DON_TC = "150202";

	// Role Thanh tra Kiem tra
	/**
	 * Truong doan
	 */
	public final static String TTKT_ROLE_TD = "Truong doan";

	/**
	 * Thu truong
	 */
	public final static String TTKT_ROLE_TT = "Thu truong";

	// KTNB message
	/**
	 * Khong the xoa cuoc Ttkt dang tien hanh
	 */
	public final static String MSG_KHG_XOA = "Cu\u1ED9c Thanh tra Ki\u1EC3m tra \u0111ang ti\u1EBFn h\u00E0nh, kh\u00F4ng th\u1EC3 x\u00F3a!";

	/**
	 * Khong the sua cuoc Ttkt dang tien hanh
	 */
	public final static String MSG_KHG_SUA = "Cu\u1ED9c Thanh tra Ki\u1EC3m tra \u0111ang ti\u1EBFn h\u00E0nh, kh\u00F4ng th\u1EC3 s\u1EEDa!";

	// Role Thanh tra Kiem tra
	/**
	 * Role nhan vien
	 */
	public final static String TTKT_ROLE_NV = "2412";

	/**
	 * Role thu truong co quan
	 */
	public final static String TTKT_ROLE_TTCQ = "2402";

	/**
	 * Role truong bo phan
	 */
	public final static String TTKT_ROLE_TBP = "2411";

	// Trang thai cho KNTC
	public final static String TT_KNTC_MOI_NHAN = "1601";
	public final static String TT_KNTC_BO_SUNG_HO_SO = "1603";

	public final static String TT_KNTC_CHO_CHUYEN_HS = "1605";
	public final static String TT_KNTC_CHO_VAN_THU_XL = "1607";

	public final static String TT_KNTC_PHAN_LOAI_DX_XLY = "1609";
	public final static String TT_KNTC_PHAN_LOAI_DX_XLY_TEXT = "Ph\u00E2n lo\u1EA1i, \u0111\u1EC1 xu\u1EA5t";

	public final static String TT_KNTC_XM = "1611";
	public final static String TT_KNTC_XM_TEXT = "X\u00E1c minh";

	public final static String TT_KNTC_KET_LUAN = "1613";
	public final static String TT_KNTC_KET_LUAN_TEXT = "\u0110ang gi\u1EA3i quy\u1EBFt";

	public final static String TT_KNTC_THI_HANH = "1615";
	public final static String TT_KNTC_THI_HANH_TEXT = "Q\u0110GQ KN/KLND TC";

	public final static String TT_KNTC_KET_THUC = "1617";
	public final static String TT_KNTC_KET_THUC_TEXT = "K\u1EBFt th\u00FAc";

	public final static String TH_KHIEU_NAI_GQ_NGAY = "170103";
	public final static String TH_KHIEU_NAI_XAC_MINH = "170101";

	public final static String TH_TO_CAO = "1703";
	public final static String XM_TVD_TRUONG_DOAN = "1703";

	// Thoi han Ttkt
	/**
	 * Quyet dinh
	 */
	public final static String TH_TTKT_QD = "1201";

	/**
	 * Lap ke hoach
	 */
	public final static String TH_TTKT_LKH = "1202";

	/**
	 * Duyet ke hoach
	 */
	public final static String TH_TTKT_DKH = "1203";

	/**
	 * De cuong
	 */
	public final static String TH_TTKT_DC = "1204";

	/**
	 * Cong bo
	 */
	public final static String TH_TTKT_CB = "1205";

	/**
	 * Ket thuc
	 */
	public final static String TH_TTKT_KT = "1206";

	/**
	 * Ket thuc thanh tra tai tong cuc
	 */
	public final static String TH_TTKT_KT_TT_TC = "120601";

	/**
	 * Ket thuc kiem tra tai tong cuc
	 */
	public final static String TH_TTKT_KT_KT_TC = "120603";

	/**
	 * Ket thuc thanh tra tai cuc
	 */
	public final static String TH_TTKT_KT_TT_C = "120605";

	/**
	 * Ket thuc kiem tra tai cuc
	 */
	public final static String TH_TTKT_KT_KT_C = "120607";

	/**
	 * Ket thuc thanh tra tai chi cuc
	 */
	public final static String TH_TTKT_KT_TT_CC = "120609";

	/**
	 * Ket thuc kiem tra tai chi cuc
	 */
	public final static String TH_TTKT_KT_KT_CC = "120611";

	/**
	 * Bao cao ket qua, du thao ket luan
	 */
	public final static String TH_TTKT_KQ = "1207";

	/**
	 * Ket luan
	 */
	public final static String TH_TTKT_KL = "1208";

	/**
	 * Ban giao ho so luu tru
	 */
	public final static String TH_TTKT_BGHSLT = "1209";

	/**
	 * Gui quyet dinh cho don vi duoc ttkt
	 */
	public final static String TH_TTKT_GQD = "1210";

	/**
	 * Chuyen giao hsvv cho co quan dieu tra
	 */
	public final static String TH_TTKT_CGHSVV = "1211";

	/**
	 * Ngay tong cuc gui ke hoach xuong dia phuong
	 */
	public final static String TH_TTKT_TCGKH = "1212";

	/**
	 * Ngay cuc gui ke hoach xuong dia phuong
	 */
	public final static String TH_TTKT_CGKH = "1213";

	/**
	 * Ngay chi cuc gui ke hoach
	 */
	public final static String TH_TTKT_CCGKH = "1214";

	/**
	 * Loai thanh tra kiem tra ke hoach
	 */
	public final static String TTKT_LOAI_KH = "KH";

	/**
	 * Loai thanh tra kiem tra dinh ky
	 */
	public final static String TTKT_LOAI_DX = "DX";
	public static final String REPORT_KN = "9801";
	public static final String REPORT_TC = "9803";
	public static final String REPORT_TTKT = "9805";
	public static final String REPORT_TTKT_ND_PARENT = "10";
	public static final String REPORT_TTKT_ND = "1901";
	public static final String REPORT_TTKT_CD = "1903";
	public static final String REPORT_KN_ND = "13";
	public static final String REPORT_TC_ND = "14";
	
	/*MAP Mẫu phụ*/
	public static String getMauPhu(int idMauPhu){
		switch (idMauPhu) {
		case 9905:
			return "05/KNTC";
		case 9906:
			return "06/KNTC";
		case 9907:
			return "07/KNTC";
		case 9908:
			return "08/KNTC";
		case 9909:
			return "09/KNTC";
		case 9922:
			return "20/KNTC";	
		case 9923:
			return "21/KNTC";
		default:
			return null;
		}
	}
	/*MAP Trang thai*/
	public static String getTenTrangThai(int idTrangThai){
		switch (idTrangThai) {
		case 1603:
			return "B&#7893; sung HSTL";
		case 1605:
			return "Chuy&#7875;n HS sang BPHC";
		case 1607:
			return "Ch&#7901; v&#259;n th&#432; x&#7917; l&#253;";
		case 1609:
			return "Ph&#226;n lo&#7841;i, &#273;&#7873; xu&#7845;t";
		case 1611:
			return "X&#225;c minh";
		case 1613:
			return "&#272;ang gi&#7843;i quy&#7871;t";	
		case 1615:
			return "Q&#272;GQ KN / KLND TC";
		case 1617:
			return "K&#7871;t th&#250;c";
		default:
			return null;
		}
	}
}