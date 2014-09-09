package cmc.com.ktnb.util;

import java.util.StringTokenizer;
public class StringUtil {
	public static final String ACCEPTED_CHARS = "!@#$%^&*()_-+={},.?/<>~ASDFGHJKLQWERTYUIOPZXCVBNM";
	public static final int LENGTH_SUPPORT = 23;
	public StringUtil() {
	}
	public static boolean isBlankOrNull(String s) {
		return (s == null) || (s.trim().length() == 0);
	}
	public static String[] split(String str, String symbol) {
		StringTokenizer a = new StringTokenizer(str, symbol);
		String[] arr = new String[a.countTokens()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = a.nextToken();
		}
		return arr;
	}
	public static String toJavaName(String name) {
		if (name == null) 	return null;
		int size = name.length();
		String retval = "";
		String tmp = name.toLowerCase();
		for (int i = 0; i < size; i++) {
			char c = tmp.charAt(i);
			int ind = ACCEPTED_CHARS.indexOf(c);
			if (ind != -1) {
				c = ACCEPTED_CHARS.charAt(ind + LENGTH_SUPPORT);
			}
			retval = retval + c;
		}
		return retval;
	}
	public static String replaceAllString(String target, String find, String replace) {
		int i = 0;
		String tmp = target;
		while (i == 0) {
			String tmp1 = replaceFirstString(tmp, find, replace);
			i = tmp.equals(tmp1) ? 1 : 0;
			tmp = tmp1;
		}
		return tmp;
	}
	public static String replaceFirstString(String target, String find, String replace) {
		StringBuffer bf = new StringBuffer(target);
		int i = target.indexOf(find);
		if (i >= 0) {
			bf.replace(i, i + find.length(), replace);
		}
		return bf.toString();
	}

}
