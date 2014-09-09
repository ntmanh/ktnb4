/*
 * Created on Apr 13, 2007
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package cmc.com.ktnb.exception;


/**
 * @author dmha
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class KtnbException extends Exception {
	
	//define some error code 
	public static final String CODE_NULL_POINTER = "NULL_ERROR";
	 
	private Throwable cause;
	private String code;
	private String additionalInfor;
	private String solution;
	private static final String NL =  System.getProperty("line.separator");
	/**
	 * 
	 */
	public KtnbException(String code, String additionalInfor) 
	{
		super(additionalInfor);
		this.cause = null;
		this.code = code;
		this.additionalInfor = additionalInfor;
		
	}
	public KtnbException(String code, String additionalInfor, String solution)
	{
		super(additionalInfor);
		this.cause = null;
		this.code = code;
		this.additionalInfor = additionalInfor;
		this.solution = solution;
	
	}
	public KtnbException(Throwable cause) 
	{
		super();
		this.cause = cause;
		this.code = null;
		this.additionalInfor = null;
	}
	
	public String getMessage(){	
		if(this.cause == null) 
		{
			return super.getMessage();		
		}
		else {
			return this.cause.getMessage();
		}
	}
	
	public void printStackTrace()
	{
		if(this.cause == null) 
		{
			super.printStackTrace();	
		}
		else 
		{
			this.cause.printStackTrace();
		}
	}
	public String toString() 
	{
		if(this.cause == null) 
		{
			return super.toString();	
		}
		else 
		{
			return this.cause.toString();
		}
	}
	public String getCode() {
		if(this.code != null) 
		{
			return this.code;	
		}
		else 
		{
			if(this.cause != null) {
				if(this.cause instanceof KtnbException ) {
					return ((KtnbException)this.cause).getCode();
				}
				else {
					return null;
				}
			}
			else 
			{
				return null;	
			}
		}
	}
	/**
	 * @return
	 */
	public String getAdditionalInfor() {
		return additionalInfor;
	}

	/**
	 * @return
	 */
	public String getSolution() {
		return solution;
	}

}
