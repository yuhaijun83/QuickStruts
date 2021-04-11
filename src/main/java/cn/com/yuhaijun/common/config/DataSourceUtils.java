/**
 * Copyright @ 2012-2022 yuhaijun.com.cn All Rights Reserved
 */
package cn.com.yuhaijun.common.config;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * XXXXXXXX
 * 
 * @author Haijun
 */
public final class DataSourceUtils {
	
	private static final String DATASOURCE_FILE = "DataSource";

	public static final String getDataSourceInfo(String key) {
		String strRet = "";
		try {
			ResourceBundle resource = ResourceBundle.getBundle(DATASOURCE_FILE, Locale.getDefault());
			strRet = resource.getString(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return strRet;
	}

}