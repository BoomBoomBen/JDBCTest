package cn.my.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws SQLException {
		String sql = "select * from user where id=1";
		search(sql);
		
		for(int i=0;i<3;i++){
		Connection conn = Java_Util.getConnection();
		System.out.println(conn);
		
		}
		
	}
	public static void search(String sql){
		Connection conn = null;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = Java_Util.getConnection();
			System.out.println(conn);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){				
				System.out.println(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
