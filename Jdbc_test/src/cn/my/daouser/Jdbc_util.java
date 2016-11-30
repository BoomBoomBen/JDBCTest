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
				//ע������
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new DaoException(e.getMessage(),e);
			}
		}
	public static Connection getConnection() throws SQLException {
		//��������
		return DriverManager.getConnection(url,user,password);
	}
	public static void realease(Connection conn,Statement st,ResultSet rs){
	    	//�ͷ���Դ
				
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
						// TODO �Զ����ɵ� catch ��
						throw new CRUDException(e.getMessage(),e);
					}
					 finally{
				    try {
                           if(conn !=null)				    	
							conn.close();
							System.out.println("���ݿ������ͷ�");
						} catch (SQLException e) {
							throw new CRUDException(e.getMessage(),e);
						}
					 }
				 }
	     }

}
