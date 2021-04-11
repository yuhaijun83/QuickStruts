/**
 * Copyright @ 2012-2022 yuhaijun.com.cn All Rights Reserved
 */
package cn.com.yuhaijun.common.exception;

/**
 * XXXXXXXX
 * 
 * @author Haijun
 */
public class DBParamCheckException extends BaseException {

	/**
     * 
     */
    private static final long serialVersionUID = 1707618284966920258L;

    /**
	 * 
	 * @param message
	 */
    public DBParamCheckException(String message) {
    	super(message);
    }

    /**
     * 
     * @param message
     * @param cause
     */
    public DBParamCheckException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * 
     * @param cause
     */
    public DBParamCheckException(Throwable cause) {
        super(cause);
    }

}
