package com.example.websocket.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBCPUtils {
	private static Properties prop = new Properties();
	private static DataSource dataSource;

	static {
		// 驱动
//		prop.setProperty("driverClassName", "com.mysql.jdbc.Driver");
		prop.setProperty("driverClassName", "com.mysql.cj.jdbc.Driver");
		// 连接url
		prop.setProperty("url", "jdbc:mysql://192.168.1.238:3306/ctf_kmg_test?serverTimezone=GMT&useUnicode=true&characterEncoding=UTF-8");
		// 用户名
		prop.setProperty("username", "root");
		// 密码
		prop.setProperty("password", "root");
		// 初始连接数
		prop.setProperty("initialSize", "5");
		// 最大活动连接数
		prop.setProperty("maxTotal", "20");
		// 最小空闲连接
		prop.setProperty("minIdle", "5");
		// 最大空闲连接
		prop.setProperty("maxIdle", "10");
		// 等待连接的最大超时时间(单位：毫秒)
		prop.setProperty("maxWaitMillis", "1000");
		// 连接未使用时是否回收
		prop.setProperty("removeAbandonedOnMaintenance", "true");
		prop.setProperty("removeAbandonedOnBorrow", "true");
		try {
			dataSource = BasicDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    public static DataSource getDataSource(){
        return dataSource;
    }
}
