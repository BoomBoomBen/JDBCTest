package p11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.my.myexciption.DaoException;

public class jdbc_util {
	 private static String url = "jdbc:mysql://localhost:3306/jdbc_test";
	 private static String user = "root";
	 private static String password = "123321";
	 private jdbc_util(){
		 
	 }
	 //注册驱动
     static{
    	 try {
    		 
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			throw new DaoException();
		}
     }
     //建立连接
     public static Connection getConnetion() throws SQLException{
    	 return DriverManager.getConnection(url,user,password);
     }
     public static void realease(Connection conn,Statement st,ResultSet rs){
    	//释放资源
			
				try {
					if(rs != null)
					rs.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					throw new CRUDException(e.getMessage(),e);
				} 
			 finally{
				 try {
					if(st != null)
					    st.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					throw new CRUDException(e.getMessage(),e);
				}
				 finally{
					 try {
						 if(conn != null){
						    conn.close();
						    System.out.println("数据库连接释放");}
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						throw new CRUDException(e.getMessage(),e);
					}
				 }
			 }
     }
}
