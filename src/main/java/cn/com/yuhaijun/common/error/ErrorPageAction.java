/**
 * Copyright @ 2012-2022 yuhaijun.com.cn All Rights Reserved
 */
package cn.com.yuhaijun.common.error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * XXXXXXXX
 * 
 * @author Haijun
 */
public class ErrorPageAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = 5975223048241343223L;
    
    /**
     * 
     */
    public ErrorPageAction() {
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
    
    /**
     * 页面的初期化。
     * 
     * @return
     */
    public String toInit() {
        String strForward = "initURL";
        
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession(true);
        

        
        return strForward;
    }

}
