package cmc.com.ktnb.util;
import java.util.Collection;

import cmc.com.ktnb.util.Constants;
public class Table 
{
  private Collection data;
  private int pageNumber=1;
  private int ordinal=0;
  private String rowStyle="row1";
  private String navigationBar;
  private String action="page";
  private boolean isLast;
  public void setData(Collection c)
  {
    this.data=c;
  }
  public Collection getData()
  {
    return this.data;
  }
  public void setPageNumber(int pn)
  {
    this.pageNumber=pn;
  }
  public int getOrdinal()
  {
    ordinal +=1;      
    return  (pageNumber-1)*Constants.PAGE_SIZE+ordinal;
  }
  public String getRowStyle()
  {
    return (this.ordinal%2==0)?"row2":"row1";
  }
  public String getNavigationBar()
  {
      StringBuffer sb=new StringBuffer("<table><tr>"); 
      String act=";document.forms[0].method.value=\""+this.action+"\";document.forms[0].submit();'";
      if (pageNumber>1)
      {
       sb.append("<td><input type='image' border='0' src='include/image/previous.jpg' accesskey='1' title='previous alt-1' onclick='javascript:document.forms[0].pn.value=");
       sb.append(pageNumber-1);
       sb.append(act);
       sb.append("/></td>");
      }
      int size=data.size();
      if (size>=Constants.PAGE_SIZE) 
      {
        sb.append("<td><font color='red'>");
        sb.append((pageNumber-1)*Constants.PAGE_SIZE+1);
        sb.append("-");
        sb.append(pageNumber*Constants.PAGE_SIZE);
        sb.append("</font></td>");
        if (!isLast)
        {
          sb.append("<td><input type='image' border='0' src='include/image/next.jpg' accesskey='2' title='next alt-2' onclick='javascript:document.forms[0].pn.value=");
          sb.append(pageNumber+1);
          sb.append(act);
          sb.append("/></td>");
        }
      }
      sb.append("</tr></table>");  
      return sb.toString();
  }

  public void setAction(String act)
  {
    this.action=act;
  }


  public void setIsLast(boolean isLast)
  {
    this.isLast = isLast;
  }

}