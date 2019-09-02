package com.ihome.util;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtil {
	
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	public static DataSource getDataSource() {
		return dataSource;
	}

}
