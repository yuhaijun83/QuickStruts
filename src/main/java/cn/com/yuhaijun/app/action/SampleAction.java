/**
 * Copyright @ 2012-2022 yuhaijun.com.cn All Rights Reserved
 */
package cn.com.yuhaijun.app.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import cn.com.yuhaijun.common.base.BaseAction;

/**
 * Sample_XXXXXXXX
 * 
 * @author Haijun
 */
public class SampleAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2582037054156172679L;

	/**
	 * 日志log
	 */
	private static final Logger logger = LogManager.getLogger(SampleAction.class.getName());
	
	private static final String SESSSION_KEY = "SampleAction_SessionKey";

	public SampleAction() {
		super();
	}

	public String toSearch() {
		String forward = "initURL";
        
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession(true);
		
		return forward;
	}
	

}
