/**
 * Copyright @ 2012-2022 yuhaijun.com.cn All Rights Reserved
 */
package cn.com.yuhaijun.common.base;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author Haijun
 */
public class BaseTABLE implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8943648712902480022L;
	
	public BaseTABLE(){
		super();
	}
	
	public static final BigDecimal BIGDECIMAL_ZERO = new BigDecimal(0);
	
	/** 其他备注 */
	public static final String REMARK = "REMARK";
	/** 删除区分 */
	public static final String DELETE_FLG = "DELETE_FLG";

	
	/**  */
	private String remark = "";
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 
	 */
	private String deleteFlg = "";
	public String getDeleteFlg() {
		return this.deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	private String indexRow = "";

	/**
	 * @return the indexRow
	 */
	public String getIndexRow() {
		return indexRow;
	}
	/**
	 * @param indexRow the indexRow to set
	 */
	public void setIndexRow(String indexRow) {
		this.indexRow = indexRow;
	}

}
