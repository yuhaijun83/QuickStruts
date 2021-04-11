/**
 * Copyright @ 2012-2022 yuhaijun.com.cn All Rights Reserved
 */
package cn.com.yuhaijun.common.exception;

/**
 * XXXXXXXX
 * 
 * @author Haijun
 */
public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8568689231244917838L;
	
	/**
	 * 
	 * @param message
	 */
    public BaseException(String message) {
    	super(message);
    }

    /**
     * 
     * @param message
     * @param cause
     */
    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * 
     * @param cause
     */
    public BaseException(Throwable cause) {
        super(cause);
    }
    
}
