/**
 * Copyright @ 2012-2022 yuhaijun.com.cn All Rights Reserved
 */
package cn.com.yuhaijun.common.exception;

/**
 * XXXXXXXX
 * 
 * @author Haijun
 */
public class FilesException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6759765364382694528L;

	/**
	 * 
	 * @param message
	 */
    public FilesException(String message) {
    	super(message);
    }

    /**
     * 
     * @param message
     * @param cause
     */
    public FilesException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * 
     * @param cause
     */
    public FilesException(Throwable cause) {
        super(cause);
    }

}
