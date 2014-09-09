package cmc.com.ktnb.web.kntc.ket_qua;

import java.io.Serializable;

public class CatalogVO implements Serializable
{
  private String ma;
  private String ten;
  private String noiDung;
  private String maKq;	  
/**
 * @return
 */
public String getMa() {
	return ma;
}

/**
 * @return
 */
public String getNoiDung() {
	return noiDung;
}

/**
 * @return
 */
public String getTen() {
	return ten;
}

/**
 * @param string
 */
public void setMa(String string) {
	ma = string;
}

/**
 * @param string
 */
public void setNoiDung(String string) {
	noiDung = string;
}

/**
 * @param string
 */
public void setTen(String string) {
	ten = string;
}

}