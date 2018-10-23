//package com.be.demo.common.config.database;
//
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//import org.springframework.transaction.support.TransactionSynchronizationManager;
//
//public class RoutingDataSource extends AbstractRoutingDataSource {
//
//	@Override
//	protected Object determineCurrentLookupKey() {
//		String dataSourceType = TransactionSynchronizationManager.isCurrentTransactionReadOnly() ? "read" : "write";
//		return dataSourceType;
//	}
//
//}
