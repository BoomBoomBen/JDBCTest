package cn.my.datasource;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class MyConnection implements Connection{
	private Connection realConnection = null;
	private MyDataSource mds = null;
	MyConnection(Connection conn,MyDataSource mds){
		this.realConnection = conn;
		this.mds = mds;
	}

	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.isWrapperFor(arg0);
	}

	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.unwrap(arg0);
	}

	public void abort(Executor executor) throws SQLException {
		realConnection.abort(executor);
		
	}

	public void clearWarnings() throws SQLException {
		realConnection.clearWarnings();
		
	}

	public void close() throws SQLException {
		mds.release(this);
		
	}

	public void commit() throws SQLException {
		realConnection.commit();
		
	}

	public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.createArrayOf(typeName, elements);
	}

	public Blob createBlob() throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.createBlob();
	}

	public Clob createClob() throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.createClob();
	}

	public NClob createNClob() throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.createNClob();
	}

	public SQLXML createSQLXML() throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.createSQLXML();
	}

	public Statement createStatement() throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.createStatement();
	}

	public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.createStatement(resultSetType, resultSetConcurrency);
	}

	public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
	}

	public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.createStruct(typeName, attributes);
	}

	public boolean getAutoCommit() throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.getAutoCommit();
	}

	public String getCatalog() throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.getCatalog();
	}

	public Properties getClientInfo() throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.getClientInfo();
	}

	public String getClientInfo(String name) throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.getClientInfo(name);
	}

	public int getHoldability() throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.getHoldability();
	}

	public DatabaseMetaData getMetaData() throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.getMetaData();
	}

	public int getNetworkTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.getNetworkTimeout();
	}

	public String getSchema() throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.getSchema();
	}

	public int getTransactionIsolation() throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.getTransactionIsolation();
	}

	public Map<String, Class<?>> getTypeMap() throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.getTypeMap();
	}

	public SQLWarning getWarnings() throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.getWarnings();
	}

	public boolean isClosed() throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.isClosed();
	}

	public boolean isReadOnly() throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.isReadOnly();
	}

	public boolean isValid(int timeout) throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.isValid(timeout);
	}

	public String nativeSQL(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.nativeSQL(sql);
	}

	public CallableStatement prepareCall(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.prepareCall(sql);
	}

	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.prepareCall(sql, resultSetType, resultSetConcurrency);
	}

	public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
	}

	public PreparedStatement prepareStatement(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.prepareStatement(sql);
	}

	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.prepareStatement(sql, autoGeneratedKeys);
	}

	public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.prepareStatement(sql, columnIndexes);
	}

	public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.prepareStatement(sql, columnNames);
	}

	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
			throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.prepareStatement(sql, resultSetType, resultSetConcurrency);
	}

	public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
			int resultSetHoldability) throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
	}

	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		// TODO Auto-generated method stub
		realConnection.releaseSavepoint(savepoint);
	}

	public void rollback() throws SQLException {
		// TODO Auto-generated method stub
		realConnection.rollback();
	}

	public void rollback(Savepoint savepoint) throws SQLException {
		// TODO Auto-generated method stub
		realConnection.rollback(savepoint);
	}

	public void setAutoCommit(boolean autoCommit) throws SQLException {
		// TODO Auto-generated method stub
		realConnection.setAutoCommit(autoCommit);
	}

	public void setCatalog(String catalog) throws SQLException {
		// TODO Auto-generated method stub
		realConnection.setCatalog(catalog);
	}

	public void setClientInfo(Properties properties) throws SQLClientInfoException {
		// TODO Auto-generated method stub
		realConnection.setClientInfo(properties);
	}

	public void setClientInfo(String name, String value) throws SQLClientInfoException {
		// TODO Auto-generated method stub
		realConnection.setClientInfo(name, value);
	}

	public void setHoldability(int holdability) throws SQLException {
		// TODO Auto-generated method stub
		realConnection.setHoldability(holdability);
	}

	public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
		// TODO Auto-generated method stub
		realConnection.setNetworkTimeout(executor, milliseconds);
	}

	public void setReadOnly(boolean readOnly) throws SQLException {
		// TODO Auto-generated method stub
		realConnection.setReadOnly(readOnly);
	}

	public Savepoint setSavepoint() throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.setSavepoint();
	}

	public Savepoint setSavepoint(String name) throws SQLException {
		// TODO Auto-generated method stub
		return realConnection.setSavepoint(name);
	}

	public void setSchema(String schema) throws SQLException {
		// TODO Auto-generated method stub
		realConnection.setSchema(schema);
	}

	public void setTransactionIsolation(int level) throws SQLException {
		// TODO Auto-generated method stub
		realConnection.setTransactionIsolation(level);
	}

	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		// TODO Auto-generated method stub
		realConnection.setTypeMap(map);
	}

}
