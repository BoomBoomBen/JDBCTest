package cn.my.daouser;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.my.myexciption.DaoException;
import p11.CRUDException;

class Jdbc_util {
	 private static String url = "jdbc:mysql://localhost:3306/jdbc_test";
	 private static String user = "root";
	 private static String password = "123321";
        static{
			try {
				//注册驱动
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new DaoException(e.getMessage(),e);
			}
		}
	public static Connection getConnection() throws SQLException {
		//返回连接
		return DriverManager.getConnection(url,user,password);
	}
	public static void realease(Connection conn,Statement st,ResultSet rs){
	    	//释放资源
				
					try {
						if(rs!= null)
						rs.close();
					} catch (SQLException e) {
						
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
                           if(conn !=null)				    	
							conn.close();
							System.out.println("数据库连接释放");
						} catch (SQLException e) {
							throw new CRUDException(e.getMessage(),e);
						}
					 }
				 }
	     }

}
