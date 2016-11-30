package cn.my.datasource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class MyDataSource implements DataSource{
	LinkedList<Connection> connectionsPool = new LinkedList<Connection>();
	String url = "jdbc:mysql://localhost:3306/jdbc_test";
	String user = "root";
	String password = "123321";
    private static int init = 3;
    private static int max = 10;
    private static int count=0;
	public MyDataSource(){
		for(int i=0;i<init;i++){
			try {
				connectionsPool.addLast(this.createConnection());
				count++;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public Connection getConnection() throws SQLException{
		synchronized (connectionsPool) {
			if(connectionsPool.size()>0)
			  return this.connectionsPool.removeFirst();
			if(count<max){
				count++;
				return this.createConnection();
			    
			}
			throw new SQLException("连接数过多");
		}
		
	}
	public void release(Connection conn){
		this.connectionsPool.addLast(conn);
	}
	private Connection createConnection() throws SQLException{
		 Connection conn = DriverManager.getConnection(url, user, password);
		 MyConnection mc = new MyConnection(conn,this);
		 return mc;
		 
	}
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}
	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public Connection getConnection(String arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
