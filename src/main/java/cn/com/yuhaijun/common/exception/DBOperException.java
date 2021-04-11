/**
 * Copyright @ 2012-2022 yuhaijun.com.cn All Rights Reserved
 */
package cn.com.yuhaijun.common.exception;

/**
 * XXXXXXXX
 * 
 * @author Haijun
 */
public class DBOperException extends BaseException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7147293056679979224L;

	/**
	 * 
	 * @param message
	 */
    public DBOperException(String message) {
    	super(message);
    }

    /**
     * 
     * @param message
     * @param cause
     */
    public DBOperException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * 
     * @param cause
     */
    public DBOperException(Throwable cause) {
        super(cause);
    }

}
