/**
 * Copyright @ 2012-2022 yuhaijun.com.cn All Rights Reserved
 */
package cn.com.yuhaijun.common.exception;

/**
 * XXXXXXXX
 * 
 * @author Haijun
 */
public class CommonException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1884174946073372630L;
	
	/**
	 * 
	 * @param message
	 */
    public CommonException(String message) {
    	super(message);
    }

    /**
     * 
     * @param message
     * @param cause
     */
    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * 
     * @param cause
     */
    public CommonException(Throwable cause) {
        super(cause);
    }

}
