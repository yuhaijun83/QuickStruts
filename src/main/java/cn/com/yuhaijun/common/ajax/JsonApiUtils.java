/**
 * Copyright @ 2012-2022 yuhaijun.com.cn All Rights Reserved
 */
package cn.com.yuhaijun.common.ajax;

import com.alibaba.fastjson.JSON;

/**
 * XXXXXXXX
 * 
 * @author Haijun
 */
public class JsonApiUtils {
	
	public static String toJSONString(Object objJson) {
		String jsonString = JSON.toJSONString(objJson);

		return jsonString;
	}

	@SuppressWarnings("unchecked")
	public static <T> T parseObject(String strJson, Class<T> clazz) {
		Object object = JSON.parseObject(strJson, clazz);

		return (T) object;
	}

}
