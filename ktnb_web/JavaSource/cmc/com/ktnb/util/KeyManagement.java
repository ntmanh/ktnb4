package cmc.com.ktnb.util;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;

public class KeyManagement 
{
  private static final SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
  private static long currentId=-1;
  private static String seqVal="0";
  public static synchronized String getGUID()  throws Exception
  {
  	String guid=null;
	try 
	{
	  if ((currentId>-1)&&(currentId<1000000)) currentId++;
	  else 
	  {
		KtnbDAO ktnbDAO=KtnbUtil.getKtnbDAO();
		try 
		{
		 seqVal=ktnbDAO.getSEQ("KEY_SEQ");
		 currentId=0;	
		} 
		catch (Exception e) {throw e;}
		finally	{KtnbUtil.releaseKtnbDAO(ktnbDAO);}		
	  }
	  guid=sdf.format(new Date())+StringUtils.leftPad(seqVal+currentId,18,"0");
	}
	catch (Exception ex){throw ex;}
	return guid;
  }
  public static synchronized String GUID(ApplicationContext context)  throws Exception
  {
	TimeZone t = TimeZone.getTimeZone("Asia/Saigon");
	sdf.setTimeZone(t);
  	String guid= context.getTenCqtVTat() + System.currentTimeMillis();
	return guid;
  }
}
