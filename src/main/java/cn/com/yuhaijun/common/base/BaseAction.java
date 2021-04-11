/**
 * Copyright @ 2012-2022 yuhaijun.com.cn All Rights Reserved
 */
package cn.com.yuhaijun.common.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

/**
 * XXXXXXXX
 * 
 * @author Haijun
 */
public abstract class BaseAction extends ActionSupport {

	/**
	 * 反序列化用ID
	 */
	private static final long serialVersionUID = -6057818857076712023L;

	/**
	 * 日志log
	 */
	private static final Logger logger = LogManager.getLogger(BaseAction.class.getName());
	
	/**
	 * 
	 */
	public BaseAction() {
		super();
	}
	
	/**
	 * 画面ID
	 */
	private String scrActionID = "";
	/**
	 * 取得 画面ID
	 * @return the scrActionID
	 */
	public String getScrActionID() {
		return scrActionID;
	}
	/**
	 * 设定 画面ID
	 * @param scrActionID the scrActionID to set
	 */
	public void setScrActionID(String scrActionID) {
		this.scrActionID = scrActionID;
	}
	
	private String fatherForward = "";
    /**
     * @return the fatherForward
     */
    public String getFatherForward() {
        return fatherForward;
    }
    /**
     * @param fatherForward the fatherForward to set
     */
    public void setFatherForward(String fatherForward) {
        this.fatherForward = fatherForward;
    }

	/**
	 * 页面的初期化。
	 * 
	 * @return
	 */
	public String toInit() {
		String strForward = "initURL";
		
		return strForward;
	}
	
	/**
	 * 
	 */
	public void validate() {

	}

}
