package cn.my.datasource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Java_Util {
	private static MyDataSource ms = new MyDataSource();
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{		
		return ms.getConnection();
	}
	public static void release(Connection conn,Statement sm,ResultSet rs){
		try {
			if(rs != null)
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(sm != null)
				sm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
				if(conn != null)
				 ms.release(conn);
			}
		}
	}

}
