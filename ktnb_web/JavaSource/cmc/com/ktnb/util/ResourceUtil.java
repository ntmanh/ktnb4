package cmc.com.ktnb.util;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.struts.util.MessageResources;
public class ResourceUtil 
{
	public static final MessageResources APP =MessageResources.getMessageResources("cmc.com.bctc.resources.ApplicationResources");	
	public static final MessageResources ERROR=MessageResources.getMessageResources("cmc.com.bctc.resources.Error_ApplicationResources");
	public static String getMessage(MessageResources mr,String key,String msg) 
	{
		String result = null;
		try 
		{
			result=mr.getMessage(key);
			if (result== null)	result = msg;
		} 
		catch (Exception ex) 
		{
			result=msg;
		}
		return result;
	}
	
	public static String getMessage(MessageResources mr,String key) 
	{
		String result =null;
		try 
		{
			result = mr.getMessage(key);
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();				
		}
		return result;
	}
	public static String getMessage(String key) 
	{
		String result =null;
		try 
		{
			result = APP.getMessage(key);
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();				
		}
		return result;
    }
    
	public static Properties load(String file) throws IOException 
	{
		Properties prop = new Properties();
		ResourceBundle bundle = ResourceBundle.getBundle(file);
		Enumeration enums = bundle.getKeys();
		String key = null;
		while (enums.hasMoreElements()) {
			key = (String) enums.nextElement();
			prop.put(key, bundle.getObject(key));
		}
		return prop;
	}
    
}
