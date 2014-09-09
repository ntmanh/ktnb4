package cmc.com.ktnb.service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import cmc.com.ktnb.vo.CategoryVO;
class LdapService 
{
	private String host="10.64.0.12";
	private String port="389";
	private String user="demo";
	private String pass="demotct";
	private String base="OU=VPUSERS,DC=vp,DC=tct,DC=vn";
	private DirContext ctx=null;
	public LdapService()
	{
	  String ldapURL="ldap://"+host+":"+port+"/"+base;
	  String sp="CN="+user+",OU=UnknowUser,"+base; 
	  Hashtable env = new Hashtable(11);
	  env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
	  env.put(Context.PROVIDER_URL,ldapURL);
	  env.put(Context.SECURITY_AUTHENTICATION,"simple");
	  env.put(Context.SECURITY_PRINCIPAL,sp);
	  env.put(Context.SECURITY_CREDENTIALS,pass);
	  try 
	  {
		ctx= new InitialDirContext(env);
	  }  	
	  catch (AuthenticationException authEx) 
	  {
		System.out.println("Authentication failed!");
	  } 
	  catch (NamingException namEx) 
	  {
		namEx.printStackTrace();
	  }
  	  catch (Exception ex) 
	  {
	   ex.printStackTrace();
	  }
	}
	private Collection search(String ou) throws Exception
	{
		SearchControls searchControls= new SearchControls();
		searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		//String bases="OU=LD";
		NamingEnumeration ne=ctx.search(ou,"(objectClass=user)",searchControls);
		Attributes attributes;
		Collection result=new ArrayList();
		CategoryVO categoryVO;
	    while (ne!=null && ne.hasMore()) 
	    {
			attributes=((SearchResult) ne.next()).getAttributes();
			categoryVO=new CategoryVO(attributes.get("mail").toString(),attributes.get("cn").toString());
			result.add(categoryVO);
	    }
	    return result;
	}
	public static void main(String[] args) throws Exception
	{
		
		LdapService ldap=new LdapService();
		Collection c;
		CategoryVO categoryVO;
		//String ou="ou=LD";
		String ou="ou=KTNB";
		c=ldap.search(ou);
		for (Iterator iter = c.iterator(); iter.hasNext();) {
			categoryVO= (CategoryVO) iter.next();
			System.out.println(categoryVO.getId()+"-"+categoryVO.getName());
		}
	}
}