package com.shaqueim.trust.database;

import com.zaxxer.hikari.HikariDataSource;

public class PoolManager {

	public PoolManager( ) {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/simpsons");
		ds.setUsername("bart");
		ds.setPassword("51mp50n");
	}
	
}
