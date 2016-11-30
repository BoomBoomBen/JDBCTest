package cn.my.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import p11.jdbc_util;

public abstract class AbstractDao {
     public int Update(String sql,Object[] obj){
    	 Connection conn = null;
    	 PreparedStatement ps = null;
    	 ResultSet rs = null;
    	 int s=0;
    	 try {
			conn = jdbc_util.getConnetion();
			ps = conn.prepareStatement(sql);
			for(int i=0;i<obj.length;i++){
				ps.setObject(i+1, obj[i]);
			}
			s = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 finally{
    		jdbc_util.realease(conn, ps, rs);
    	 }
    	 return s;
    	 
     }
}
