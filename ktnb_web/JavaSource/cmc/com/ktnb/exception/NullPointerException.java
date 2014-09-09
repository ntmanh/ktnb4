/*
 * Created on Apr 16, 2007
 */
package cmc.com.ktnb.exception;

/**
 * @author ntthu
 */
public class NullPointerException extends KtnbException {

	/**
	 * @param code
	 * @param additionalInfor
	 */
	public NullPointerException(String additionalInfor) {
		super(KtnbException.CODE_NULL_POINTER, additionalInfor);
	}

}
