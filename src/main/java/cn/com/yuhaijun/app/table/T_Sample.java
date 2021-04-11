/**
 * Copyright @ 2012-2022 yuhaijun.com.cn All Rights Reserved
 */
package cn.com.yuhaijun.app.table;

import cn.com.yuhaijun.common.base.BaseTABLE;

/**
 * T_Sample
 * 
 * @author Haijun
 */
public class T_Sample extends BaseTABLE {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8385513093147702081L;

	public T_Sample() {
		init();
	}
	
	public final static String T_USER = "T_SAMPLE";

	public final static String SAMPLE_ID = "SAMPLE_ID";
	public final static String SAMPLE_PASS = "SAMPLE_PASS";
	
	private String sampleID = "";
	private String sampleName = "";


	/**
	 * @return the sampleID
	 */
	public String getSampleID() {
		return sampleID;
	}

	/**
	 * @param sampleID the sampleID to set
	 */
	public void setSampleID(String sampleID) {
		this.sampleID = sampleID;
	}

	/**
	 * @return the sampleName
	 */
	public String getSampleName() {
		return sampleName;
	}

	/**
	 * @param sampleName the sampleName to set
	 */
	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}

	public void init(){
		this.setSampleID("");
		this.setSampleName("");
		
		this.setRemark("");
	}

	public boolean equals (Object obj) {
		
		if (null == obj || !(obj instanceof T_Sample)) {
			return false;
		}
		
		T_Sample mObj = (T_Sample) obj;
		
		return this.getSampleID().equals(mObj.getSampleID());
	}

	public int hashCode () {
		return this.getSampleID().hashCode();
	}

}
