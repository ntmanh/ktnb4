package cmc.com.ktnb.vo;

import cmc.com.ktnb.util.Constants;

public class SearchVO {
    public  int pn=1;
	public  String macqt;
	public  String maphong;
	public  String ten;
	public int getFromRow(){
	 return Constants.PAGE_SIZE*(pn-1)+1;
	}
	public int getToRow(){
	   return  Constants.PAGE_SIZE*pn;
	} 
}
