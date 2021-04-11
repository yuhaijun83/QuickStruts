/**
 * Copyright @ 2012-2022 yuhaijun.com.cn All Rights Reserved
 */
package cn.com.yuhaijun.common.ajax;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

/**
 * XXXXXXXX
 * 
 * @author Haijun
 */
public class AjaxAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2309193368878006412L;
	
	/**
	 * 日志log
	 */
	private static final Logger logger = LogManager.getLogger(AjaxAction.class.getName());
	
	/**
	 * Json data 用 
	 */
	private String jsonData = "";
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	
	/**
	 * Json data 用 
	 */
	private Map<String,Object> jsonDataMap;
	public Map<String, Object> getJsonDataMap() {
		return jsonDataMap;
	}
	public void setJsonDataMap(Map<String, Object> jsonDataMap) {
		this.jsonDataMap = jsonDataMap;
	}
	
	/**
	 * 
	 * @return
	 */
	public String toGetInfo() {
		
		this.jsonData = JsonApiUtils.toJSONString("");
		
		return SUCCESS;
	}

}
