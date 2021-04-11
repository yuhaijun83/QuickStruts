/**
 * Copyright @ 2012-2022 yuhaijun.com.cn All Rights Reserved
 */
package cn.com.yuhaijun.common.database;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.com.yuhaijun.common.config.DataSourceUtils;

/**
 * XXXXXXXX
 * 
 * @author Haijun
 */
public class DBConnManager {
    
    private static final Logger logger = LogManager.getLogger(DBConnManager.class.getName());
    
    /** DEFAULT_DBNAME: MAIN */
    private static final String DEFAULT_DBNAME = "MAIN";
    
    /**
     * ThreadLocal
     * 它为null表示没有事务，它不为null表示有事务
     * 当事物开始时，需要给它赋值，当事务结束时，需要给它赋值null
     * 并且在开启事务时，让dao的多个方法共享这个Connection
     */
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    /** 数据源集合 */
	private static Map<String, ComboPooledDataSource> dataSourcesMap = new ConcurrentHashMap<String, ComboPooledDataSource>();
	
    /**
     * 初始化数据源。
     * 
     * @throws SQLException
     */
    private static final void init(final String dbName) throws SQLException {

        logger.debug(">>>>>>>>>>>>>>>>>>>>> <DBConnManager.init()> Begin...");
        
        // 建立数据库连接池
        String DRIVER_NAME = DataSourceUtils.getDataSourceInfo(dbName.concat(".DRIVER_NAME")); // 驱动器
        String DATABASE_URL = DataSourceUtils.getDataSourceInfo(dbName.concat(".DATABASE_URL")); // 数据库连接url
        String DATABASE_USER = DataSourceUtils.getDataSourceInfo(dbName.concat(".DATABASE_USER")); // 数据库用户名
        String DATABASE_PASS = DataSourceUtils.getDataSourceInfo(dbName.concat(".DATABASE_PASS")); // 数据库密码

        int Initial_PoolSize = 5;
        int Min_PoolSize = 5;
        int Max_PoolSize = 30;
        int Acquire_Increment = 5;
        int Idle_Test_Period = 3000;// 每隔3000s测试连接是否可以正常使用
        String Validate = "false";

        // 初始化连接数
        try {
            Initial_PoolSize = Integer.parseInt(DataSourceUtils.getDataSourceInfo(dbName.concat(".Initial_PoolSize")));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // 最小连接数
        try {
            Min_PoolSize = Integer.parseInt(DataSourceUtils.getDataSourceInfo(dbName.concat(".Min_PoolSize")));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // 最大连接数
        try {
            Max_PoolSize = Integer.parseInt(DataSourceUtils.getDataSourceInfo(dbName.concat(".Max_PoolSize")));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // 增量条数
        try {
            Acquire_Increment = Integer.parseInt(DataSourceUtils.getDataSourceInfo(dbName.concat(".Acquire_Increment")));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // 每隔3000s测试连接是否可以正常使用
        try {
            Idle_Test_Period = Integer.parseInt(DataSourceUtils.getDataSourceInfo(dbName.concat(".Idle_Test_Period")));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // 每次连接验证连接是否可用
        Validate = DataSourceUtils.getDataSourceInfo(dbName.concat(".Validate"));

        try {
            
        	ComboPooledDataSource cpds = new ComboPooledDataSource();
        	
            cpds.setDriverClass(DRIVER_NAME); // 驱动器
            cpds.setJdbcUrl(DATABASE_URL); // 数据库url
            cpds.setUser(DATABASE_USER); // 用户名
            cpds.setPassword(DATABASE_PASS); // 密码
            
            cpds.setInitialPoolSize(Initial_PoolSize); // 初始化连接池大小
            cpds.setMinPoolSize(Min_PoolSize); // 最少连接数
            cpds.setMaxPoolSize(Max_PoolSize); // 最大连接数
            cpds.setAcquireIncrement(Acquire_Increment); // 连接数的增量
            cpds.setIdleConnectionTestPeriod(Idle_Test_Period); // 测连接有效的时间间隔
            cpds.setTestConnectionOnCheckout(Boolean.getBoolean(Validate)); // 每次连接验证连接是否可用
            
            dataSourcesMap.put(dbName, cpds);
            
        } catch (PropertyVetoException e) {
            
            logger.error(">>>>>>>>>>>>>>>>>>>>> <DBConnManager.init()> PropertyVetoException Error:" + e);
            
            throw new SQLException(e.getMessage());
        }

        logger.debug(">>>>>>>>>>>>>>>>>>>>> <DBConnManager.init()> End...");
    }

     /**
      * 需要手动开始事务时，获取数据库连接。
      * 
      * @return
      * @throws SQLException
      */
    public static final Connection getConnection() throws SQLException {
        
        // 获取当前线程的事务连接
        Connection connection = threadLocal.get();
        
        if (null == connection) {
        	
        	ComboPooledDataSource cpds = dataSourcesMap.get(DEFAULT_DBNAME);
            if (null == cpds) {
                init(DEFAULT_DBNAME);
                cpds = dataSourcesMap.get(DEFAULT_DBNAME);
                connection = cpds.getConnection();
            } else {
                connection = cpds.getConnection();
            }
            
        }
        
        return connection;
    }
    
    /**
     * 需要手动开始事务时，获取数据库连接。
     * 
     * @param dbName
     * @return
     * @throws SQLException
     */
    public static final Connection getConnection(String dbName) throws SQLException {
        
        // 获取当前线程的事务连接
        Connection connection = threadLocal.get();
        
        if (null == connection) {
        	
        	ComboPooledDataSource cpds = dataSourcesMap.get(dbName);
            if (null == cpds) {
                init(dbName);
                cpds = dataSourcesMap.get(dbName);
                connection = cpds.getConnection();
            } else {
                connection = cpds.getConnection();
            }
            
        }
        
        return connection;
    }

    /**
     * 关闭数据源。
     */
    public static final void closeDataSource() {
    	ComboPooledDataSource cpds = dataSourcesMap.get(DEFAULT_DBNAME);
        if (null != cpds) {
            cpds.close();
            cpds = null;
        }
    }

    /**
     * 关闭数据源。
     * 
     * @param dbName
     */
    public static final void closeDataSource(String dbName) {
    	ComboPooledDataSource cpds = dataSourcesMap.get(dbName);
        if (null != cpds) {
            cpds.close();
            cpds = null;
        }
    }

    /**
     * 开启事务。
     * 
     * @throws SQLException 
     */
    public static final void beginTransaction() throws SQLException {
        
        // 获取当前线程的事务连接
        Connection connection = threadLocal.get();
        if(null != connection) {
            throw new SQLException("已开启事务，不能重复开启！");
        }
        
        // 给connection赋值，表示开启了事务
        connection = getConnection();
        // 设置为手动提交
        connection.setAutoCommit(false);
        
        // 把当前事务连接放到tl中
        threadLocal.set(connection);
    }

    /**
     * 开启事务。
     * 
     * @param dbName
     * @throws SQLException
     */
    public static final void beginTransaction(String dbName) throws SQLException {
        
        // 获取当前线程的事务连接
        Connection connection = threadLocal.get();
        if(null != connection) {
            throw new SQLException("已开启事务，不能重复开启！");
        }
        
        // 给connection赋值，表示开启了事务
        connection = getConnection(dbName);
        // 设置为手动提交
        connection.setAutoCommit(false);
        
        // 把当前事务连接放到tl中
        threadLocal.set(connection);
    }

    /**
     * 提交事务。
     * 
     * @throws SQLException 
     */
    public static final void commitTransaction() throws SQLException {
        
        // 获取当前线程的事务连接
        Connection connection = threadLocal.get();
        
        if(null == connection) {
            throw new SQLException("没有事务，不能提交！");
        }
        
        // 提交事务
        connection.commit();
        // 关闭连接
        connection.close();
        
        connection = null;
        threadLocal.remove();
    }

    /**
     * 回滚事务。
     * 
     * @throws SQLException 
     */
    public static final void rollbackTransaction() throws SQLException {
        
        // 获取当前线程的事务连接
        Connection connection = threadLocal.get();
        
        if(null == connection) {
            throw new SQLException("没有事务，不能回滚！");
        }
        
        // 回滚事务
        connection.rollback();
        // 关闭连接
        connection.close();
        
        connection = null;
        threadLocal.remove();
    }

    /**
     * 释放连接资源。
     * 
     * @param conn
     * @throws SQLException
     */
    public static final void closeConnection(Connection conn) {
        
        // 获取当前线程的事务连接
        Connection connection = threadLocal.get();
        
        try {
        	
	        if(null != conn && connection != conn) {
	            // 如果参数连接，与当前事务连接不同，说明这个连接不是当前事务，可以关闭！
                conn.close();
                conn = null;
	        }
	        
        } catch (SQLException e) {
            ;
        }
    }

    /**
     * 释放连接资源。
     * 
     * @param conn
     * @throws SQLException
     */
    public static final void closeConnection(ResultSet resultSet, PreparedStatement preState, Connection conn) {
        
        // 获取当前线程的事务连接
        Connection connection = threadLocal.get();
        
        try {
        	
			if (null != resultSet) {
				resultSet.close();
				resultSet = null;
			}
			if (null != preState) {
				preState.close();
				preState = null;
			}
	        if(null != conn && connection != conn) {
	            // 如果参数连接，与当前事务连接不同，说明这个连接不是当前事务，可以关闭！
                conn.close();
                conn = null;
	        }
        
        } catch (SQLException e) {
            ;
        }
    }

    /**
     * 释放连接资源。
     * 
     * @param conn
     * @throws SQLException
     */
    public static final void closeConnection(ResultSet resultSet, Statement statement, Connection conn) {
        
        // 获取当前线程的事务连接
        Connection connection = threadLocal.get();
        
        try {
        	
			if (null != resultSet) {
				resultSet.close();
				resultSet = null;
			}
			if (null != statement) {
				statement.close();
				statement = null;
			}
	        if(null != conn && connection != conn) {
	            // 如果参数连接，与当前事务连接不同，说明这个连接不是当前事务，可以关闭！
                conn.close();
                conn = null;
	        }
        
        } catch (SQLException e) {
            ;
        }
    }
    
}
