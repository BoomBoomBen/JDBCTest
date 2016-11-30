package p11;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc_meta {
	public static void main(String args[]){
		String sql = "select id,age,name from user where id>? and age>?";
		Object[] param = new Object[]{"4","30"};
		read(sql,param);
		
	}
	public static void read(String sql,Object[] param){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = jdbc_util.getConnetion();
			ps = conn.prepareStatement(sql);
			ParameterMetaData pmd = ps.getParameterMetaData();
			int count = pmd.getParameterCount();
			for(int i=1;i<=count;i++){
				ps.setObject(i, param[i-1]);
			}
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			jdbc_util.realease(conn, ps, rs);
		}
	}

}
