package com.be.demo.common.config.database;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
// @EnableJpaRepositories("com.be.demo.common.repository")
// @EntityScan("com.be.demo.common.model")
// @EnableTransactionManagement
public class DatabaseConfig {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.write.hikari")
	public HikariConfig hikariWriteConfig() {
		return new HikariConfig();
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.read.hikari")
	public HikariConfig hikariReadConfig() {
		return new HikariConfig();
	}

	@Primary
	@Bean(destroyMethod = "close")
	public DataSource writeDataSource() {
		return new HikariDataSource(hikariWriteConfig());
	}

	@Bean(destroyMethod = "close")
	public DataSource readDataSource() {
		return new HikariDataSource(hikariReadConfig());

	}

	@Bean
	public DataSource routingDataSource(@Qualifier("writeDataSource") DataSource writeDataSource,
			@Qualifier("readDataSource") DataSource readDataSource) {
		RoutingDataSource routingDataSource = new RoutingDataSource();

		Map<Object, Object> dataSourceMap = new HashMap<Object, Object>();
		dataSourceMap.put("write", writeDataSource);
		dataSourceMap.put("read", readDataSource);
		routingDataSource.setTargetDataSources(dataSourceMap);
		routingDataSource.setDefaultTargetDataSource(writeDataSource);

		return routingDataSource;
	}

	@Bean
	public DataSource dataSource(@Qualifier("routingDataSource") DataSource routingDataSource) {
		return new LazyConnectionDataSourceProxy(routingDataSource);
	}

	public class RoutingDataSource extends AbstractRoutingDataSource {

		@Override
		protected Object determineCurrentLookupKey() {
			String dataSourceType = TransactionSynchronizationManager.isCurrentTransactionReadOnly() ? "read" : "write";
			return dataSourceType;
		}

	}

}
