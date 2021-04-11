/**
 * Copyright @ 2012-2022 yuhaijun.com.cn All Rights Reserved
 */
package cn.com.yuhaijun.app.bo;

import java.sql.SQLException;

import cn.com.yuhaijun.common.base.BaseBO;
import cn.com.yuhaijun.common.database.DBConnManager;

/**
 * Sample_XXXXXXXX
 * 
 * @author Haijun
 */
public class SampleBO extends BaseBO {
	
    public int toSave() throws SQLException {
        int iRet = 0;
        
        try {
            DBConnManager.beginTransaction();
            
            
            
            
            DBConnManager.commitTransaction();
            
        } catch (SQLException e) {
             
            DBConnManager.rollbackTransaction();
            
            throw new SQLException(e.getMessage());
        } 
        
        return iRet;
    }


}
