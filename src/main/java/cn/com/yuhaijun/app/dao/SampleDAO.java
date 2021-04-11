/**
 * Copyright @ 2012-2022 yuhaijun.com.cn All Rights Reserved
 */
package cn.com.yuhaijun.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cn.com.yuhaijun.app.table.T_Sample;
import cn.com.yuhaijun.app.vo.SampleVO;
import cn.com.yuhaijun.common.base.BaseDAO;
import cn.com.yuhaijun.common.database.DBConnManager;
import cn.com.yuhaijun.common.exception.DBOperException;
import cn.com.yuhaijun.common.exception.DBParamCheckException;

/**
 * XXXXXXXX
 * 
 * @author Haijun
 */
public class SampleDAO extends BaseDAO {
	
	private static final Logger logger = LogManager.getLogger(SampleDAO.class.getName());
	
	private OjbectVOBuilder objBuilder = new OjbectVOBuilder();

	/**
	 * T_SAMPLE_XXXXXXX
	 * 
	 * @param pamamSQL
	 * @return
	 * @throws DBOperException
	 */
	public List<SampleVO> toSelectSampleBySQL(String pamamSQL) throws DBOperException {
		List<SampleVO> resultVOList = null;
		
		String strSQL = "SELECT * FROM T_SAMPLE WHERE DELETE_FLG != '1'";
		if (StringUtils.isNotEmpty(pamamSQL)) {
			strSQL = pamamSQL;
		}
		
		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {

			conn = DBConnManager.getConnection();

			statement = conn.createStatement();
			resultSet = statement.executeQuery(strSQL);
	        
	        if (resultSet.getFetchSize() > 0) {
	        	resultVOList = new ArrayList<SampleVO>();
	        }

			while (resultSet.next()) {
				resultVOList.add(this.objBuilder.build(resultSet));
			}
			
		} catch (SQLException e) {
			
			logger.error("SampleDAO.toSelectSampleBySQL(pamamSQL) SQL:" + strSQL);
			logger.error("SampleDAO.toSelectSampleBySQL(pamamSQL) SQLException Error:" + e);
			throw new DBOperException(e.getMessage());
			
		} finally {
			DBConnManager.closeConnection(resultSet, statement, conn);
		}

		return resultVOList;
	}

	/**
	 * T_SAMPLE_XXXXXXX
	 * 
	 * @param id
	 * @return
	 * @throws DBOperException
	 * @throws DBParamCheckException 
	 */
	public SampleVO toSelectSampleByPK(String id) throws DBOperException, DBParamCheckException {
        
        if (StringUtils.isEmpty(id)) {
            // COMMOM-INFO-E007=参数【{0}】不得为空！
            throw new DBParamCheckException("XXXXX");
        }
		
		SampleVO resultVO = null;
		String strSQL = "SELECT * FROM T_USER WHERE USER_ID = ? AND DELETE_FLG != '1'";
		
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement preState = null;
		
		try {

			conn = DBConnManager.getConnection();
			
			preState = conn.prepareStatement(strSQL);
	        preState.setString(1, id);
	        
	        resultSet = preState.executeQuery();
			
			if(resultSet.next()) {
				resultVO = this.objBuilder.build(resultSet);
			}
			
		} catch (SQLException e) {

			logger.error("SampleDAO.toSelectSampleByPK(id) SQL:" + strSQL);
			logger.error("SampleDAO.toSelectSampleByPK(id) SQLPamam id:" +  id);
			logger.error("SampleDAO.toSelectSampleByPK(id) SQLException Error:" + e);
			throw new DBOperException(e.getMessage());
			
		} finally {
			DBConnManager.closeConnection(resultSet, preState, conn);
		}
		
		return resultVO;
	}

	class OjbectVOBuilder {
	
		/**
		 * <p>从ResultSet中获取数据，构建VO对象</p>
		 * @param resultSet
		 * @return
		 * @throws DBOperException 
		 *
		 */
		public SampleVO build(ResultSet resultSet) throws DBOperException   {
			SampleVO record = new SampleVO();
			try{
				record.setDeleteFlg(resultSet.getString(T_Sample.SAMPLE_ID));


				
			} catch (SQLException e) {
				logger.error("SampleDAO.OjbectVOBuilder.build() SQLException Error:" + e);
				throw new DBOperException(e.getMessage());
			}
			
			return record;
		}
		
	}
	
	// 自己用DAO Begin
	
	
	// 自己用DAO End

}
