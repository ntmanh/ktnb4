package cmc.com.ktnb.util;

import java.io.Serializable;
import java.util.ArrayList;

public class DetailInformation implements Serializable
{  
  private String col0;      
  private String col1;
  private String col2;
  private String col3;
  private String col4;
  private String col5;
  private String col6;
  private String col7;
  private String col8;
  private String col9;
  private String col10;
  private String col11;
  private String col12;
  private String col13;
  private String col14;
  private String col15;
  private String col16;
  private int ordinal;
  private String status;
  private boolean active=false; 
  public DetailInformation()  {}


  public void setCol0(String col0)
  {
    this.col0 = col0;
  }


  public String getCol0()
  {
    return col0;
  }


  public void setCol1(String col1)
  {
    this.col1 = col1;
  }


  public String getCol1()
  {
    return col1;
  }


  public void setCol2(String col2)
  {
    this.col2 = col2;
  }


  public String getCol2()
  {
    return col2;
  }


  public void setCol3(String col3)
  {
    this.col3 = col3;
  }


  public String getCol3()
  {
    return col3;
  }


  public void setCol4(String col4)
  {
    this.col4 = col4;
  }


  public String getCol4()
  {
    return col4;
  }


  public void setCol5(String col5)
  {
    this.col5 = col5;
  }


  public String getCol5()
  {
    return col5;
  }


  public void setCol6(String col6)
  {
    this.col6 = col6;
  }


  public String getCol6()
  {
    return col6;
  }


  public void setCol7(String col7)
  {
    this.col7 = col7;
  }


  public String getCol7()
  {
    return col7;
  }


  public void setCol8(String col8)
  {
    this.col8 = col8;
  }


  public String getCol8()
  {
    return col8;
  }


  public void setCol9(String col9)
  {
    this.col9 = col9;
  }


  public String getCol9()
  {
    return col9;
  }


  public void setCol10(String col10)
  {
    this.col10 = col10;
  }


  public String getCol10()
  {
    return col10;
  }


  public void setOrdinal(int ordinal)
  {
    this.ordinal = ordinal;
  }


  public int getOrdinal()
  {
    return ordinal;
  }


  public void setActive(boolean active)
  {
    this.active = active;
  }


  public boolean isActive()
  {
    return active;
  }


  public void setCol11(String col11)
  {
    this.col11 = col11;
  }


  public String getCol11()
  {
    return col11;
  }


  public void setCol12(String col12)
  {
    this.col12 = col12;
  }


  public String getCol12()
  {
    return col12;
  }


  public void setCol13(String col13)
  {
    this.col13 = col13;
  }


  public String getCol13()
  {
    return col13;
  }


  public void setCol14(String col14)
  {
    this.col14 = col14;
  }


  public String getCol14()
  {
    return col14;
  }


  public void setCol15(String col15)
  {
    this.col15 = col15;
  }


  public String getCol15()
  {
    return col15;
  }
  public static DetailInformation[] convertFromArrayList(ArrayList arrInput){
  	DetailInformation[] arrOutput = new DetailInformation[arrInput.size()];
  	for(int i = 0; i< arrInput.size(); i++){
  		arrOutput[i] = (DetailInformation) arrInput.get(i);
  	}
  	return arrOutput;
  }
  
  
/**
 * @return
 */
public String getStatus() {
	return status;
}

/**
 * @param string
 */
public void setStatus(String string) {
	status = string;
}

/**
 * @return
 */
public String getCol16() {
	return col16;
}

/**
 * @param string
 */
public void setCol16(String string) {
	col16 = string;
}

}