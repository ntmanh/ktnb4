package cmc.com.ktnb.util;
/**
 *  Conversion of text and HTML files in various Vietnamese encodings to Unicode Strings.
 * @author     Nguyen Thac Thu
 * @version    1.0.7, 2003-01-11
 */
import java.io.UnsupportedEncodingException;

public class UnicodeConversion
{
	// Instance variable
	private String str;
	private boolean html;

	// Fonts for HTML font tags.
	private final static String SERIF = "Tahoma";
	private final static String SANS_SERIF = "Tahoma";

	public UnicodeConversion()
	{
	}

	/**
	 *  Constructor for the UnicodeConversion object
	 *
	 * @param  source      The string to convert
	 * @param  encoding  One of "VISCII", "VPS", "VNI", "VIQR", or "TCVN","NCR"
	 */
	
	public UnicodeConversion(String source, String encoding, boolean html)
	{
		this.str = source;
		this.html = html;

		if (encoding.equalsIgnoreCase("VISCII")) {
			VISCIItoUnicode();
		} else if (encoding.equalsIgnoreCase("VPS")) {
			VPStoUnicode();
		} else if (encoding.equalsIgnoreCase("VNI")) {
			VNItoUnicode();
		} else if (encoding.equalsIgnoreCase("VIQR/Vietnet")) {
			VIQRtoUnicode("VIQR");
		} else if (encoding.equalsIgnoreCase("Unicode")) {
			VIQRtoUnicode("Unicode");
		} else if (encoding.equalsIgnoreCase("TCVN")) {
			TCVNtoUnicode();
		} else if (encoding.equalsIgnoreCase("NCR")) {
			NCRtoUnicode();
		} else if (encoding.equalsIgnoreCase("UTF-8")) {
			UTF8toUnicode();
		} else {
			throw new RuntimeException("Unsupported encoding: " + encoding);
		}
	}

	/**
	 *  Multiple String replacement
	 *
	 */
	String replaceString(String text, final String[] pattern,
			final String[] replace)
	{
		int startIndex;
		int foundIndex;
		StringBuffer result = new StringBuffer();

		for (int i = 0; i < pattern.length; i++) {
			startIndex = 0;
			// Clear the buffer
			result.setLength(0);

			// Look for a pattern to replace
			while ((foundIndex = text.indexOf(pattern[i], startIndex)) >= 0) {
				result.append(text.substring(startIndex, foundIndex));
				result.append(replace[i]);
				startIndex = foundIndex + pattern[i].length();
			}
			result.append(text.substring(startIndex));
			text = result.toString();
		}
		return text;
	}

	/**
	 *  String replacement
	 *
	 */
	String replaceString(String text, final String pattern, final String replace)
	{
		int startIndex = 0;
		int foundIndex;
		StringBuffer result = new StringBuffer();

		// Look for a pattern to replace
		while ((foundIndex = text.indexOf(pattern, startIndex)) >= 0) {
			result.append(text.substring(startIndex, foundIndex));
			result.append(replace);
			startIndex = foundIndex + pattern.length();
		}
		result.append(text.substring(startIndex));
		return result.toString();
	}

	/**
	 *  String replacement ignoring case
	 *
	 */
	String replaceStringIgnoreCase(String text, final String pattern,
			final String replace)
	{
		int startIndex = 0;
		int foundIndex;
		StringBuffer result = new StringBuffer();

		// Look for a pattern to replace
		while ((foundIndex = text.toLowerCase().indexOf(pattern.toLowerCase(),
				startIndex)) >= 0) {
			result.append(text.substring(startIndex, foundIndex));
			result.append(replace);
			startIndex = foundIndex + pattern.length();
		}
		result.append(text.substring(startIndex));
		return result.toString();
	}

	/**
	 *  Massage the string content prior to actual conversion process.
	 *
	 */
	void prepareMetaTag()
	{
		str = replaceStringIgnoreCase(str, "charset=iso-8859-1", "");
		str = replaceStringIgnoreCase(str, "charset=windows-1252", "");
		str = replaceStringIgnoreCase(str, "charset=windows-1258", "");
		str = replaceStringIgnoreCase(str, "charset=us-ascii", "");
		str = replaceStringIgnoreCase(str, "charset=x-user-defined", "");
		str = replaceStringIgnoreCase(str,
				"<meta http-equiv=Content-Type content=\"text/html; \">", "");
		str = replaceStringIgnoreCase(str,
				"<meta http-equiv=Content-Type content=\"text/html;\">", "");
		str = replaceStringIgnoreCase(str,
				"<meta http-equiv=\"Content-Type\" content=\"text/html; \">",
				"");
		str = replaceStringIgnoreCase(str,
				"<meta http-equiv=\"Content-Type\" content=\"text/html;\">", "");
		str = replaceStringIgnoreCase(str, "<head>",
				"<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
	}

	/**
	 *  Translate Character entity references to corresponding Cp1252 characters.
	 *
	 */
	void HTMLtoANSI()
	{
		final String[] extended_ansi_html = {"&trade;", "&#8209;", "&#2;",
				"&#3;", "&#4;", "&#5;", "&#6;", "&#16;", "&#17;", "&#18;",
				"&#19;", "&#20;", "&#21;", "&#25;", "&nbsp;", "&iexcl;",
				"&cent;", "&pound;", "&curren;", "&yen;", "&brvbar;", "&sect;",
				"&uml;", "&copy;", "&ordf;", "&laquo;", "&not;", "&shy;",
				"&reg;", "&macr;", "&deg;", "&plusmn;", "&sup2;", "&sup3;",
				"&acute;", "&micro;", "&para;", "&middot;", "&cedil;",
				"&sup1;", "&ordm;", "&raquo;", "&frac14;", "&frac12;",
				"&frac34;", "&iquest;", "&Agrave;", "&Aacute;", "&Acirc;",
				"&Atilde;", "&Auml;", "&Aring;", "&AElig;", "&Ccedil;",
				"&Egrave;", "&Eacute;", "&Ecirc;", "&Euml;", "&Igrave;",
				"&Iacute;", "&Icirc;", "&Iuml;", "&ETH;", "&Ntilde;",
				"&Ograve;", "&Oacute;", "&Ocirc;", "&Otilde;", "&Ouml;",
				"&times;", "&Oslash;", "&Ugrave;", "&Uacute;", "&Ucirc;",
				"&Uuml;", "&Yacute;", "&THORN;", "&szlig;", "&agrave;",
				"&aacute;", "&acirc;", "&atilde;", "&auml;", "&aring;",
				"&aelig;", "&ccedil;", "&egrave;", "&eacute;", "&ecirc;",
				"&euml;", "&igrave;", "&iacute;", "&icirc;", "&iuml;", "&eth;",
				"&ntilde;", "&ograve;", "&oacute;", "&ocirc;", "&otilde;",
				"&ouml;", "&divide;", "&oslash;", "&ugrave;", "&uacute;",
				"&ucirc;", "&uuml;", "&yacute;", "&thorn;", "&yuml;"};
		final String[] extended_ansi = {"\u0099", "\u2011", "\u0002", "\u0003",
				"\u0004", "\u0005", "\u0006", "\u0010", "\u0011", "\u0012",
				"\u0013", "\u0014", "\u0015", "\u0019", "\u00A0", "\u00A1",
				"\u00A2", "\u00A3", "\u00A4", "\u00A5", "\u00A6", "\u00A7",
				"\u00A8", "\u00A9", "\u00AA", "\u00AB", "\u00AC", "\u00AD",
				"\u00AE", "\u00AF", "\u00B0", "\u00B1", "\u00B2", "\u00B3",
				"\u00B4", "\u00B5", "\u00B6", "\u00B7", "\u00B8", "\u00B9",
				"\u00BA", "\u00BB", "\u00BC", "\u00BD", "\u00BE", "\u00BF",
				"\u00C0", "\u00C1", "\u00C2", "\u00C3", "\u00C4", "\u00C5",
				"\u00C6", "\u00C7", "\u00C8", "\u00C9", "\u00CA", "\u00CB",
				"\u00CC", "\u00CD", "\u00CE", "\u00CF", "\u00D0", "\u00D1",
				"\u00D2", "\u00D3", "\u00D4", "\u00D5", "\u00D6", "\u00D7",
				"\u00D8", "\u00D9", "\u00DA", "\u00DB", "\u00DC", "\u00DD",
				"\u00DE", "\u00DF", "\u00E0", "\u00E1", "\u00E2", "\u00E3",
				"\u00E4", "\u00E5", "\u00E6", "\u00E7", "\u00E8", "\u00E9",
				"\u00EA", "\u00EB", "\u00EC", "\u00ED", "\u00EE", "\u00EF",
				"\u00F0", "\u00F1", "\u00F2", "\u00F3", "\u00F4", "\u00F5",
				"\u00F6", "\u00F7", "\u00F8", "\u00F9", "\u00FA", "\u00FB",
				"\u00FC", "\u00FD", "\u00FE", "\u00FF"};

		str = replaceString(str, extended_ansi_html, extended_ansi);
	}

	/**
	 *  Translate Numeric Character References (NCR) to characters \u0080 - \u00FF.
	 *
	 */
	void NCRtoHex()
	{
		final String[] NCRChar = {"&#128;", "&#129;", "&#130;", "&#131;",
				"&#132;", "&#133;", "&#134;", "&#135;", "&#136;", "&#137;",
				"&#138;", "&#139;", "&#140;", "&#141;", "&#142;", "&#143;",
				"&#144;", "&#145;", "&#146;", "&#147;", "&#148;", "&#149;",
				"&#150;", "&#151;", "&#152;", "&#153;", "&#154;", "&#155;",
				"&#156;", "&#157;", "&#158;", "&#159;", "&#160;", "&#161;",
				"&#162;", "&#163;", "&#164;", "&#165;", "&#166;", "&#167;",
				"&#168;", "&#169;", "&#170;", "&#171;", "&#172;", "&#173;",
				"&#174;", "&#175;", "&#176;", "&#177;", "&#178;", "&#179;",
				"&#180;", "&#181;", "&#182;", "&#183;", "&#184;", "&#185;",
				"&#186;", "&#187;", "&#188;", "&#189;", "&#190;", "&#191;",
				"&#192;", "&#193;", "&#194;", "&#195;", "&#196;", "&#197;",
				"&#198;", "&#199;", "&#200;", "&#201;", "&#202;", "&#203;",
				"&#204;", "&#205;", "&#206;", "&#207;", "&#208;", "&#209;",
				"&#210;", "&#211;", "&#212;", "&#213;", "&#214;", "&#215;",
				"&#216;", "&#217;", "&#218;", "&#219;", "&#220;", "&#221;",
				"&#222;", "&#223;", "&#224;", "&#225;", "&#226;", "&#227;",
				"&#228;", "&#229;", "&#230;", "&#231;", "&#232;", "&#233;",
				"&#234;", "&#235;", "&#236;", "&#237;", "&#238;", "&#239;",
				"&#240;", "&#241;", "&#242;", "&#243;", "&#244;", "&#245;",
				"&#246;", "&#247;", "&#248;", "&#249;", "&#250;", "&#251;",
				"&#252;", "&#253;", "&#254;", "&#255;"};
		final String[] ansiChar = {"\u0080", "\u0081", "\u0082", "\u0083",
				"\u0084", "\u0085", "\u0086", "\u0087", "\u0088", "\u0089",
				"\u008A", "\u008B", "\u008C", "\u008D", "\u008E", "\u008F",
				"\u0090", "\u0091", "\u0092", "\u0093", "\u0094", "\u0095",
				"\u0096", "\u0097", "\u0098", "\u0099", "\u009A", "\u009B",
				"\u009C", "\u009D", "\u009E", "\u009F", "\u00A0", "\u00A1",
				"\u00A2", "\u00A3", "\u00A4", "\u00A5", "\u00A6", "\u00A7",
				"\u00A8", "\u00A9", "\u00AA", "\u00AB", "\u00AC", "\u00AD",
				"\u00AE", "\u00AF", "\u00B0", "\u00B1", "\u00B2", "\u00B3",
				"\u00B4", "\u00B5", "\u00B6", "\u00B7", "\u00B8", "\u00B9",
				"\u00BA", "\u00BB", "\u00BC", "\u00BD", "\u00BE", "\u00BF",
				"\u00C0", "\u00C1", "\u00C2", "\u00C3", "\u00C4", "\u00C5",
				"\u00C6", "\u00C7", "\u00C8", "\u00C9", "\u00CA", "\u00CB",
				"\u00CC", "\u00CD", "\u00CE", "\u00CF", "\u00D0", "\u00D1",
				"\u00D2", "\u00D3", "\u00D4", "\u00D5", "\u00D6", "\u00D7",
				"\u00D8", "\u00D9", "\u00DA", "\u00DB", "\u00DC", "\u00DD",
				"\u00DE", "\u00DF", "\u00E0", "\u00E1", "\u00E2", "\u00E3",
				"\u00E4", "\u00E5", "\u00E6", "\u00E7", "\u00E8", "\u00E9",
				"\u00EA", "\u00EB", "\u00EC", "\u00ED", "\u00EE", "\u00EF",
				"\u00F0", "\u00F1", "\u00F2", "\u00F3", "\u00F4", "\u00F5",
				"\u00F6", "\u00F7", "\u00F8", "\u00F9", "\u00FA", "\u00FB",
				"\u00FC", "\u00FD", "\u00FE", "\u00FF"};

		str = replaceString(str, NCRChar, ansiChar);
	}

	/**
	 *  VISCII-to-Unicode conversion.
	 *
	 */
	void VISCIItoUnicode()
	{
		if (html) {
			NCRtoHex();
			HTMLtoANSI();
			prepareMetaTag();

			// Replace fonts
			str = replaceString(str, "VI Times", SERIF);
			str = replaceString(str, "VI Arial", SANS_SERIF);
			str = replaceString(str, "Heo May Hoa 1.1", SERIF);
			str = replaceString(str, "Heo May 1.1", SERIF);
			str = replaceString(str, "HoangYenH 1.1", SERIF);
			str = replaceString(str, "HoangYen 1.1", SERIF);
			str = replaceString(str, "MinhQu\u00E2nH 1.1", SERIF);
			str = replaceString(str, "MinhQu\u00E2n 1.1", SERIF);
			str = replaceString(str, "PhuongThaoH 1.1", SERIF);
			str = replaceString(str, "PhuongThao 1.1", SERIF);
			str = replaceString(str, "ThaHuongH 1.1", SERIF);
			str = replaceString(str, "ThaHuong 1.1", SERIF);
			str = replaceString(str, "UHo\u00E0iH 1.1", SERIF);
			str = replaceString(str, "UHo\u00E0i 1.1", SERIF);
		}

		final char[] VISCII_char = {'\u2011', '\u00C5', '\u00E5', '\u00F0',
				'\u00CE', '\u00EE', '\u009D', '\u00FB', '\u00B4', '\u00BD',
				'\u00BF', '\u00DF', '\u0080', '\u00D5', '\u00C4', '\u00E4',
				'\u0084', '\u00A4', '\u0085', '\u00A5', '\u0086', '\u00A6',
				'\u0006', '\u00E7', '\u0087', '\u00A7', '\u0081', '\u00A1',
				'\u0082', '\u00A2', '\u0002', '\u00C6', '\u0005', '\u00C7',
				'\u0083', '\u00A3', '\u0089', '\u00A9', '\u00CB', '\u00EB',
				'\u0088', '\u00A8', '\u008A', '\u00AA', '\u008B', '\u00AB',
				'\u008C', '\u00AC', '\u008D', '\u00AD', '\u008E', '\u00AE',
				'\u009B', '\u00EF', '\u0098', '\u00B8', '\u009A', '\u00F7',
				'\u0099', '\u00F6', '\u008F', '\u00AF', '\u0090', '\u00B0',
				'\u0091', '\u00B1', '\u0092', '\u00B2', '\u0093', '\u00B5',
				'\u0095', '\u00BE', '\u0096', '\u00B6', '\u0097', '\u00B7',
				'\u00B3', '\u00DE', '\u0094', '\u00FE', '\u009E', '\u00F8',
				'\u009C', '\u00FC', '\u00BA', '\u00D1', '\u00BB', '\u00D7',
				'\u00BC', '\u00D8', '\u00FF', '\u00E6', '\u00B9', '\u00F1',
				'\u009F', '\u00CF', '\u001E', '\u00DC', '\u0014', '\u00D6',
				'\u0019', '\u00DB', '\u00A0'};
		final char[] Unicode_char = {'\u1EF4', '\u0102', '\u0103', '\u0111',
				'\u0128', '\u0129', '\u0168', '\u0169', '\u01A0', '\u01A1',
				'\u01AF', '\u01B0', '\u1EA0', '\u1EA1', '\u1EA2', '\u1EA3',
				'\u1EA4', '\u1EA5', '\u1EA6', '\u1EA7', '\u1EA8', '\u1EA9',
				'\u1EAA', '\u1EAB', '\u1EAC', '\u1EAD', '\u1EAE', '\u1EAF',
				'\u1EB0', '\u1EB1', '\u1EB2', '\u1EB3', '\u1EB4', '\u1EB5',
				'\u1EB6', '\u1EB7', '\u1EB8', '\u1EB9', '\u1EBA', '\u1EBB',
				'\u1EBC', '\u1EBD', '\u1EBE', '\u1EBF', '\u1EC0', '\u1EC1',
				'\u1EC2', '\u1EC3', '\u1EC4', '\u1EC5', '\u1EC6', '\u1EC7',
				'\u1EC8', '\u1EC9', '\u1ECA', '\u1ECB', '\u1ECC', '\u1ECD',
				'\u1ECE', '\u1ECF', '\u1ED0', '\u1ED1', '\u1ED2', '\u1ED3',
				'\u1ED4', '\u1ED5', '\u1ED6', '\u1ED7', '\u1ED8', '\u1ED9',
				'\u1EDA', '\u1EDB', '\u1EDC', '\u1EDD', '\u1EDE', '\u1EDF',
				'\u1EE0', '\u1EE1', '\u1EE2', '\u1EE3', '\u1EE4', '\u1EE5',
				'\u1EE6', '\u1EE7', '\u1EE8', '\u1EE9', '\u1EEA', '\u1EEB',
				'\u1EEC', '\u1EED', '\u1EEE', '\u1EEF', '\u1EF0', '\u1EF1',
				'\u1EF2', '\u1EF3', '\u1EF4', '\u1EF5', '\u1EF6', '\u1EF7',
				'\u1EF8', '\u1EF9', '\u00D5'};
		for (int i = 0; i < VISCII_char.length; i++) {
			str = str.replace(VISCII_char[i], Unicode_char[i]);
		}
	}

	/**
	 *  VIQR-to-Unicode conversion.
	 *
	 */
	void VIQRtoUnicode(String UnicodeVIQR)
	{
		final String[] VIQR_char = {"y~", "Y~", "y?", "Y?", "y.", "Y.", "y`",
				"Y`", "u+.", "U+.", "u+~", "U+~", "u+?", "U+?", "u+`", "U+`",
				"u+'", "U+'", "u?", "U?", "u.", "U.", "o+.", "O+.", "o+~",
				"O+~", "o+?", "O+?", "o+`", "O+`", "o+'", "O+'", "o^.", "O^.",
				"o^~", "O^~", "o^?", "O^?", "o^`", "O^`", "o^'", "O^'", "o?",
				"O?", "o.", "O.", "i.", "I.", "i?", "I?", "e^.", "E^.", "e^~",
				"E^~", "e^?", "E^?", "e^`", "E^`", "e^'", "E^'", "e~", "E~",
				"e?", "E?", "e.", "E.", "a(.", "A(.", "a(~", "A(~", "a(?",
				"A(?", "a(`", "A(`", "a('", "A('", "a^.", "A^.", "a^~", "A^~",
				"a^?", "A^?", "a^`", "A^`", "a^'", "A^'", "a?", "A?", "a.",
				"A.", "u+", "U+", "o+", "O+", "u~", "U~", "i~", "I~", "dd",
				"a(", "A(", "y'", "u'", "u`", "o~", "o^", "o'", "o`", "i'",
				"i`", "e^", "e'", "e`", "a~", "a^", "a'", "a`", "Y'", "U'",
				"U`", "O~", "O^", "O'", "O`", "DD", "I'", "I`", "E^", "E'",
				"E`", "A~", "A^", "A'", "A`"};
		final String[] Unicode_char = {"\u1EF9", "\u1EF8", "\u1EF7", "\u1EF6",
				"\u1EF5", "\u1EF4", "\u1EF3", "\u1EF2", "\u1EF1", "\u1EF0",
				"\u1EEF", "\u1EEE", "\u1EED", "\u1EEC", "\u1EEB", "\u1EEA",
				"\u1EE9", "\u1EE8", "\u1EE7", "\u1EE6", "\u1EE5", "\u1EE4",
				"\u1EE3", "\u1EE2", "\u1EE1", "\u1EE0", "\u1EDF", "\u1EDE",
				"\u1EDD", "\u1EDC", "\u1EDB", "\u1EDA", "\u1ED9", "\u1ED8",
				"\u1ED7", "\u1ED6", "\u1ED5", "\u1ED4", "\u1ED3", "\u1ED2",
				"\u1ED1", "\u1ED0", "\u1ECF", "\u1ECE", "\u1ECD", "\u1ECC",
				"\u1ECB", "\u1ECA", "\u1EC9", "\u1EC8", "\u1EC7", "\u1EC6",
				"\u1EC5", "\u1EC4", "\u1EC3", "\u1EC2", "\u1EC1", "\u1EC0",
				"\u1EBF", "\u1EBE", "\u1EBD", "\u1EBC", "\u1EBB", "\u1EBA",
				"\u1EB9", "\u1EB8", "\u1EB7", "\u1EB6", "\u1EB5", "\u1EB4",
				"\u1EB3", "\u1EB2", "\u1EB1", "\u1EB0", "\u1EAF", "\u1EAE",
				"\u1EAD", "\u1EAC", "\u1EAB", "\u1EAA", "\u1EA9", "\u1EA8",
				"\u1EA7", "\u1EA6", "\u1EA5", "\u1EA4", "\u1EA3", "\u1EA2",
				"\u1EA1", "\u1EA0", "\u01B0", "\u01AF", "\u01A1", "\u01A0",
				"\u0169", "\u0168", "\u0129", "\u0128", "\u0111", "\u0103",
				"\u0102", "\u00FD", "\u00FA", "\u00F9", "\u00F5", "\u00F4",
				"\u00F3", "\u00F2", "\u00ED", "\u00EC", "\u00EA", "\u00E9",
				"\u00E8", "\u00E3", "\u00E2", "\u00E1", "\u00E0", "\u00DD",
				"\u00DA", "\u00D9", "\u00D5", "\u00D4", "\u00D3", "\u00D2",
				"\u0110", "\u00CD", "\u00CC", "\u00CA", "\u00C9", "\u00C8",
				"\u00C3", "\u00C2", "\u00C1", "\u00C0"};
		/**
		 *  Unicode-to-VIQR conversion
		 *  Placed inside this method to share the VIQR and Unicode
		 *  data arrays
		 *
		 */
		if (UnicodeVIQR.equals("Unicode")) {
			//str.Replace(".", "\\.");
			str = replaceString(str, ".", "\\.");
			//str.Replace("?", "\\?");
			str = replaceString(str, "?", "\\?");
			//str.Replace("DD", "D\\D");
			str = replaceString(str, "DD", "D\\D");
			//str.Replace("dd", "d\\d");
			str = replaceString(str, "dd", "d\\d");
			//str.Replace("\'", "\\\'");
			str = replaceString(str, "\'", "\\\'");

			for (int i = 0; i < Unicode_char.length; i++) {
				str = replaceString(str, Unicode_char[i], VIQR_char[i]);
			}

			return;
		}

		if (html) {
			HTMLtoANSI();
			prepareMetaTag();
			NCRtoHex();
		}

		str = replaceString(str, "u*", "u+");
		str = replaceString(str, "U*", "U+");
		str = replaceString(str, "o*", "o+");
		str = replaceString(str, "O*", "O+");
		str = replaceString(str, "Dd", "DD");
		str = replaceString(str, "D-", "DD");
		str = replaceString(str, "d-", "dd");

		str = str.replace('\u0092', '\''); // replace right single quotation mark (\u0092, or \u2019) with apostrophe

		str = replaceString(str, VIQR_char, Unicode_char);

		str = replaceString(str, "\\.", ".");
		str = replaceString(str, "\\?", "?");
		str = replaceString(str, "\\d", "d");
		str = replaceString(str, "\\D", "D");
		str = replaceString(str, "\\'", "'");
		str = replaceString(str, "\\-", "-");
		str = replaceString(str, "\\\\", "\\");

	}

	/**
	 *  VNI-to-Unicode conversion process consisting of 3 parts. Part 1 converts
	 *  single-byte (ASCII) characters except O+ and U+ because they are also
	 *  used as base in some VNI double-byte characters. Part 2 converts VNI
	 *  double-byte characters. Part 3 converts O+ and U+.
	 */
	void VNItoUnicode()
	{
		if (html) {
			HTMLtoANSI();
			prepareMetaTag();

			// Replace fonts
			str = replaceString(str, "VNI Times", SERIF);
			str = replaceString(str, "VNI-Times", SERIF);
			str = replaceString(str, "VNI Couri", SERIF);
			str = replaceString(str, "VNI Centur", SERIF);
			str = replaceString(str, "VNI Brush", SERIF);
			str = replaceString(str, "VNI Helve", SANS_SERIF);
			str = replaceString(str, "VNI-Helve", SANS_SERIF);
			str = replaceString(str, "VNI Aptima", SANS_SERIF);
			str = replaceString(str, "VNI-Aptima", SANS_SERIF);
		}

		// Part 1
		str = str.replace('\u00D1', '\u0110'); // DD
		str = str.replace('\u00F1', '\u0111'); // dd
		str = str.replace('\u00D3', '\u0128'); // I~
		str = str.replace('\u00F3', '\u0129'); // i~
		str = str.replace('\u00D2', '\u1ECA'); // I.
		str = str.replace('\u00F2', '\u1ECB'); // i.
		str = str.replace('\u00C6', '\u1EC8'); // I?
		str = str.replace('\u00E6', '\u1EC9'); // i?
		str = str.replace('\u00CE', '\u1EF4'); // Y.
		str = str.replace('\u00EE', '\u1EF5'); // y.

		// Part 2
		// Transform "O\u00C2" -> "\u00C6" to later transform back to "\u00D4" in Part 3
		final String[] VNI_char = {"O\u00C2", "o\u00E2", "y\u00F5", "Y\u00D5",
				"y\u00FB", "Y\u00DB", "y\u00F8", "Y\u00D8", "\u00F6\u00EF",
				"\u00D6\u00CF", "\u00F6\u00F5", "\u00D6\u00D5", "\u00F6\u00FB",
				"\u00D6\u00DB", "\u00F6\u00F8", "\u00D6\u00D8", "\u00F6\u00F9",
				"\u00D6\u00D9", "u\u00FB", "U\u00DB", "u\u00EF", "U\u00CF",
				"\u00F4\u00EF", "\u00D4\u00CF", "\u00F4\u00F5", "\u00D4\u00D5",
				"\u00F4\u00FB", "\u00D4\u00DB", "\u00F4\u00F8", "\u00D4\u00D8",
				"\u00F4\u00F9", "\u00D4\u00D9", "o\u00E4", "O\u00C4",
				"o\u00E3", "O\u00C3", "o\u00E5", "O\u00C5", "o\u00E0",
				"O\u00C0", "o\u00E1", "O\u00C1", "o\u00FB", "O\u00DB",
				"o\u00EF", "O\u00CF", "e\u00E4", "E\u00C4", "e\u00E3",
				"E\u00C3", "e\u00E5", "E\u00C5", "e\u00E0", "E\u00C0",
				"e\u00E1", "E\u00C1", "e\u00F5", "E\u00D5", "e\u00FB",
				"E\u00DB", "e\u00EF", "E\u00CF", "a\u00EB", "A\u00CB",
				"a\u00FC", "A\u00DC", "a\u00FA", "A\u00DA", "a\u00E8",
				"A\u00C8", "a\u00E9", "A\u00C9", "a\u00E4", "A\u00C4",
				"a\u00E3", "A\u00C3", "a\u00E5", "A\u00C5", "a\u00E0",
				"A\u00C0", "a\u00E1", "A\u00C1", "a\u00FB", "A\u00DB",
				"a\u00EF", "A\u00CF", "u\u00F5", "U\u00D5", "a\u00EA",
				"A\u00CA", "y\u00F9", "u\u00F9", "u\u00F8", "o\u00F5",
				"o\u00F9", "o\u00F8", "e\u00E2", "e\u00F9", "e\u00F8",
				"a\u00F5", "a\u00E2", "a\u00F9", "a\u00F8", "Y\u00D9",
				"U\u00D9", "U\u00D8", "O\u00D5", "O\u00D9", "O\u00D8",
				"E\u00C2", "E\u00D9", "E\u00D8", "A\u00D5", "A\u00C2",
				"A\u00D9", "A\u00D8"};
		final String[] Unicode_char = {"\u00C6", "\u00E6", "\u1EF9", "\u1EF8",
				"\u1EF7", "\u1EF6", "\u1EF3", "\u1EF2", "\u1EF1", "\u1EF0",
				"\u1EEF", "\u1EEE", "\u1EED", "\u1EEC", "\u1EEB", "\u1EEA",
				"\u1EE9", "\u1EE8", "\u1EE7", "\u1EE6", "\u1EE5", "\u1EE4",
				"\u1EE3", "\u1EE2", "\u1EE1", "\u1EE0", "\u1EDF", "\u1EDE",
				"\u1EDD", "\u1EDC", "\u1EDB", "\u1EDA", "\u1ED9", "\u1ED8",
				"\u1ED7", "\u1ED6", "\u1ED5", "\u1ED4", "\u1ED3", "\u1ED2",
				"\u1ED1", "\u1ED0", "\u1ECF", "\u1ECE", "\u1ECD", "\u1ECC",
				"\u1EC7", "\u1EC6", "\u1EC5", "\u1EC4", "\u1EC3", "\u1EC2",
				"\u1EC1", "\u1EC0", "\u1EBF", "\u1EBE", "\u1EBD", "\u1EBC",
				"\u1EBB", "\u1EBA", "\u1EB9", "\u1EB8", "\u1EB7", "\u1EB6",
				"\u1EB5", "\u1EB4", "\u1EB3", "\u1EB2", "\u1EB1", "\u1EB0",
				"\u1EAF", "\u1EAE", "\u1EAD", "\u1EAC", "\u1EAB", "\u1EAA",
				"\u1EA9", "\u1EA8", "\u1EA7", "\u1EA6", "\u1EA5", "\u1EA4",
				"\u1EA3", "\u1EA2", "\u1EA1", "\u1EA0", "\u0169", "\u0168",
				"\u0103", "\u0102", "\u00FD", "\u00FA", "\u00F9", "\u00F5",
				"\u00F3", "\u00F2", "\u00EA", "\u00E9", "\u00E8", "\u00E3",
				"\u00E2", "\u00E1", "\u00E0", "\u00DD", "\u00DA", "\u00D9",
				"\u00D5", "\u00D3", "\u00D2", "\u00CA", "\u00C9", "\u00C8",
				"\u00C3", "\u00C2", "\u00C1", "\u00C0"};

		str = replaceString(str, VNI_char, Unicode_char);

		// Part 3
		str = str.replace('\u00D4', '\u01A0'); // O+
		str = str.replace('\u00F4', '\u01A1'); // o+
		str = str.replace('\u00D6', '\u01AF'); // U+
		str = str.replace('\u00F6', '\u01B0'); // u+
		str = str.replace('\u00C6', '\u00D4'); // O^
		str = str.replace('\u00E6', '\u00F4'); // o^
	}

	/**
	 *  VPS-to-Unicode conversion.
	 *
	 */
	void VPStoUnicode()
	{
		if (html) {
			HTMLtoANSI();
			prepareMetaTag();
			NCRtoHex();

			// Replace fonts, longer names first!
			str = replaceString(str, "VPS Times Hoa", SERIF);
			str = replaceString(str, "VPS Times", SERIF);
			str = replaceString(str, "VPS Helv Hoa", SANS_SERIF);
			str = replaceString(str, "VPS Helv", SANS_SERIF);
			str = replaceString(str, "VPS Long An Hoa", SERIF);
			str = replaceString(str, "VPS Long An", SERIF);
			str = replaceString(str, "VPS Nam Dinh Hoa", SERIF);
			str = replaceString(str, "VPS Nam Dinh", SERIF);
			str = replaceString(str, "VPS Ninh Binh Hoa", SERIF);
			str = replaceString(str, "VPS Ninh Binh", SERIF);
		}

		final char[] VPS_char = {'\u00CF', '\u00B3', '\u009B', '\u00FD',
				'\u009C', '\u0019', '\u00FF', '\u00B2', '\u00BF', '\u0015',
				'\u00BB', '\u001D', '\u00BA', '\u00B1', '\u00D8', '\u00AF',
				'\u00D9', '\u00AD', '\u00FB', '\u00D1', '\u00F8', '\u0014',
				'\u00AE', '\u0013', '\u00AB', '\u00A6', '\u00AA', '\u009F',
				'\u00A9', '\u009E', '\u00A7', '\u009D', '\u00B6', '\u0012',
				'\u0087', '\u0099', '\u00B0', '\u0098', '\u00D2', '\u0097',
				'\u00D3', '\u0096', '\u00D5', '\u00BD', '\u0086', '\u0011',
				'\u00CE', '\u0010', '\u00CC', '\u00B7', '\u008C', '\u0006',
				'\u00CD', '\u0095', '\u008B', '\u0094', '\u008A', '\u0093',
				'\u0089', '\u0090', '\u00EB', '\u00FE', '\u00C8', '\u00DE',
				'\u00CB', '\u0005', '\u00A5', '\u0004', '\u00A4', '\u00F0',
				'\u00A3', '\u008F', '\u00A2', '\u008E', '\u00A1', '\u008D',
				'\u00C6', '\u0003', '\u00C5', '\u001C', '\u00C4', '\u0085',
				'\u00C0', '\u0084', '\u00C3', '\u0083', '\u00E4', '\u0081',
				'\u00E5', '\u0002', '\u00DC', '\u00D0', '\u00D6', '\u00F7',
				'\u00DB', '\u00AC', '\u00EF', '\u00B8', '\u00C7', '\u00E6',
				'\u0088', '\u009A', '\u00A8', '\u00BE', '\u00B9', '\u00BC',
				'\u00F1', '\u00B4', '\u00B5', '\u00D7', '\u0082', '\u0080'};
		final char[] Unicode_char = {'\u1EF9', '\u1EF8', '\u1EF7', '\u1EF6',
				'\u1EF5', '\u1EF4', '\u1EF3', '\u1EF2', '\u1EF1', '\u1EF0',
				'\u1EEF', '\u1EEE', '\u1EED', '\u1EEC', '\u1EEB', '\u1EEA',
				'\u1EE9', '\u1EE8', '\u1EE7', '\u1EE6', '\u1EE5', '\u1EE4',
				'\u1EE3', '\u1EE2', '\u1EE1', '\u1EE0', '\u1EDF', '\u1EDE',
				'\u1EDD', '\u1EDC', '\u1EDB', '\u1EDA', '\u1ED9', '\u1ED8',
				'\u1ED7', '\u1ED6', '\u1ED5', '\u1ED4', '\u1ED3', '\u1ED2',
				'\u1ED1', '\u1ED0', '\u1ECF', '\u1ECE', '\u1ECD', '\u1ECC',
				'\u1ECB', '\u1ECA', '\u1EC9', '\u1EC8', '\u1EC7', '\u1EC6',
				'\u1EC5', '\u1EC4', '\u1EC3', '\u1EC2', '\u1EC1', '\u1EC0',
				'\u1EBF', '\u1EBE', '\u1EBD', '\u1EBC', '\u1EBB', '\u1EBA',
				'\u1EB9', '\u1EB8', '\u1EB7', '\u1EB6', '\u1EB5', '\u1EB4',
				'\u1EB3', '\u1EB2', '\u1EB1', '\u1EB0', '\u1EAF', '\u1EAE',
				'\u1EAD', '\u1EAC', '\u1EAB', '\u1EAA', '\u1EA9', '\u1EA8',
				'\u1EA7', '\u1EA6', '\u1EA5', '\u1EA4', '\u1EA3', '\u1EA2',
				'\u1EA1', '\u1EA0', '\u01B0', '\u01AF', '\u01A1', '\u01A0',
				'\u0169', '\u0168', '\u0129', '\u0128', '\u0111', '\u0103',
				'\u0102', '\u00FD', '\u00D9', '\u00D5', '\u00D3', '\u00D2',
				'\u0110', '\u00CD', '\u00CC', '\u00C8', '\u00C3', '\u00C0'};
		for (int i = 0; i < VPS_char.length; i++) {
			str = str.replace(VPS_char[i], Unicode_char[i]);
		}
	}

	/**
	 *  TCVN-to-Unicode conversion
	 *
	 */
	void TCVNtoUnicode()
	{
		if (html) {
			HTMLtoANSI();
			prepareMetaTag();

			// Replace fonts
			str = replaceString(str, ".VnTimeH", SERIF);
			str = replaceString(str, ".VnTime", SERIF);
			str = replaceString(str, ".VnArialH", SANS_SERIF);
			str = replaceString(str, ".VnArial", SANS_SERIF);
		}

		final char[] TCVN_char = {'\u00FC', '\u00FB', '\u00FE', '\u00FA',
				'\u00F9', '\u00F7', '\u00F6', '\u00F5', '\u00F8', '\u00F1',
				'\u00F4', '\u00EE', '\u00EC', '\u00EB', '\u00EA', '\u00ED',
				'\u00E9', '\u00E7', '\u00E6', '\u00E5', '\u00E8', '\u00E1',
				'\u00E4', '\u00DE', '\u00D8', '\u00D6', '\u00D4', '\u00D3',
				'\u00D2', '\u00D5', '\u00CF', '\u00CE', '\u00D1', '\u00C6',
				'\u00BD', '\u00BC', '\u00AB', '\u00BE', '\u00CB', '\u00C9',
				'\u00C8', '\u00C7', '\u00CA', '\u00B6', '\u00B9', '\u00AD',
				'\u00A6', '\u00AC', '\u00A5', '\u00F2', '\u00DC', '\u00AE',
				'\u00A8', '\u00A1', '\u00F3', '\u00EF', '\u00E2', '\u00BB',
				'\u00E3', '\u00DF', '\u00DD', '\u00D7', '\u00AA', '\u00D0',
				'\u00CC', '\u00B7', '\u00A9', '\u00B8', '\u00B5', '\u00A4',
				'\u00A7', '\u00A3', '\u00A2'};
		final char[] Unicode_char = {'\u1EF9', '\u1EF7', '\u1EF5', '\u1EF3',
				'\u1EF1', '\u1EEF', '\u1EED', '\u1EEB', '\u1EE9', '\u1EE7',
				'\u1EE5', '\u1EE3', '\u1EE1', '\u1EDF', '\u1EDD', '\u1EDB',
				'\u1ED9', '\u1ED7', '\u1ED5', '\u1ED3', '\u1ED1', '\u1ECF',
				'\u1ECD', '\u1ECB', '\u1EC9', '\u1EC7', '\u1EC5', '\u1EC3',
				'\u1EC1', '\u1EBF', '\u1EBD', '\u1EBB', '\u1EB9', '\u1EB7',
				'\u1EB5', '\u1EB3', '\u00F4', '\u1EAF', '\u1EAD', '\u1EAB',
				'\u1EA9', '\u1EA7', '\u1EA5', '\u1EA3', '\u1EA1', '\u01B0',
				'\u01AF', '\u01A1', '\u01A0', '\u0169', '\u0129', '\u0111',
				'\u0103', '\u0102', '\u00FA', '\u00F9', '\u00F5', '\u1EB1',
				'\u00F3', '\u00F2', '\u00ED', '\u00EC', '\u00EA', '\u00E9',
				'\u00E8', '\u00E3', '\u00E2', '\u00E1', '\u00E0', '\u00D4',
				'\u0110', '\u00CA', '\u00C2'};

		for (int i = 0; i < TCVN_char.length; i++) {
			str = str.replace(TCVN_char[i], Unicode_char[i]);
		}

		final String[] TCVN_cap = {"\u0041\u00E0", "\u0041\u1EA3",
				"\u0041\u00E3", "\u0041\u00E1", "\u0041\u1EA1", "\u0045\u00E8",
				"\u0045\u1EBB", "\u0045\u1EBD", "\u0045\u00E9", "\u0045\u1EB9",
				"\u0049\u00EC", "\u0049\u1EC9", "\u0049\u0129", "\u0049\u00ED",
				"\u0049\u1ECB", "\u004F\u00F2", "\u004F\u1ECF", "\u004F\u00F5",
				"\u004F\u00F3", "\u004F\u1ECD", "\u0055\u00F9", "\u0055\u1EE7",
				"\u0055\u0169", "\u0055\u00FA", "\u0055\u1EE5", "\u0059\u1EF3",
				"\u0059\u1EF7", "\u0059\u1EF9", "\u0059\u00FD", "\u0059\u1EF5",
				"\u0102\u1EB1", "\u0102\u1EB3", "\u0102\u1EB5", "\u0102\u1EAF",
				"\u0102\u1EB7", "\u00C2\u1EA7", "\u00C2\u1EA9", "\u00C2\u1EAB",
				"\u00C2\u1EA5", "\u00C2\u1EAD", "\u00CA\u1EC1", "\u00CA\u1EC3",
				"\u00CA\u1EC5", "\u00CA\u1EBF", "\u00CA\u1EC7", "\u00D4\u1ED3",
				"\u00D4\u1ED5", "\u00D4\u1ED7", "\u00D4\u1ED1", "\u00D4\u1ED9",
				"\u01A0\u1EDD", "\u01A0\u1EDF", "\u01A0\u1EE1", "\u01A0\u1EDB",
				"\u01A0\u1EE3", "\u01AF\u1EEB", "\u01AF\u1EED", "\u01AF\u1EEF",
				"\u01AF\u1EE9", "\u01AF\u1EF1"};
		final String[] Unicode_cap = {"\u00C0", "\u1EA2", "\u00C3", "\u00C1",
				"\u1EA0", "\u00C8", "\u1EBA", "\u1EBC", "\u00C9", "\u1EB8",
				"\u00CC", "\u1EC8", "\u0128", "\u00CD", "\u1ECA", "\u00D2",
				"\u1ECE", "\u00D5", "\u00D3", "\u1ECC", "\u00D9", "\u1EE6",
				"\u0168", "\u00DA", "\u1EE4", "\u1EF2", "\u1EF6", "\u1EF8",
				"\u00DD", "\u1EF4", "\u1EB0", "\u1EB2", "\u1EB4", "\u1EAE",
				"\u1EB6", "\u1EA6", "\u1EA8", "\u1EAA", "\u1EA4", "\u1EAC",
				"\u1EC0", "\u1EC2", "\u1EC4", "\u1EBE", "\u1EC6", "\u1ED2",
				"\u1ED4", "\u1ED6", "\u1ED0", "\u1ED8", "\u1EDC", "\u1EDE",
				"\u1EE0", "\u1EDA", "\u1EE2", "\u1EEA", "\u1EEC", "\u1EEE",
				"\u1EE8", "\u1EF0"};

		str = replaceString(str, TCVN_cap, Unicode_cap);
	}

	/**
	 *  UTF8-to-Unicode conversion
	 *
	 */
	void UTF8toUnicode()
	{
		try {
			str = new String(str.getBytes("Cp1252"), "UTF-8");
		} catch (UnsupportedEncodingException exc) {
			throw new RuntimeException("Unsupported encoding.");
		}
	}

	/**
	 *  Numeric Character References-to-Unicode conversion
	 *
	 */
	void NCRtoUnicode()
	{
		StringBuffer ostr = new StringBuffer();
		int i1 = 0;
		int i2 = 0;

		while (i2 < str.length()) {
			i1 = str.indexOf("&#", i2);

			if (i1 == -1) {
				ostr.append(str.substring(i2, str.length()));
				break;
			}

			ostr.append(str.substring(i2, i1));
			i2 = str.indexOf(";", i1);

			if (i2 == -1) {
				ostr.append(str.substring(i1, str.length()));
				break;
			}

			String tok = str.substring(i1 + 2, i2);

			try {
				int radix = 10;

				if (tok.trim().charAt(0) == 'x') {
					radix = 16;
					tok = tok.substring(1, tok.length());
				}

				ostr.append((char) Integer.parseInt(tok, radix));
			} catch (NumberFormatException exp) {
				ostr.append('?');
			}

			i2++;
		}

		str = ostr.toString();
	}

	/**
	 *  Textual representation of UnicodeConversion Object
	 * @return    Instance variable str
	 */
	public String convert()
	{
		return str;
	}
	public static void main(String[] args) {
		UnicodeConversion uc = new UnicodeConversion("TV","TCVN",false);
}
}
