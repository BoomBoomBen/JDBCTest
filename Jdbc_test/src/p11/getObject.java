package p11;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class getObject {
	public static void main(String args[]){
		User1 u = (User1)getObejct("select name as Name,age as Age,id as Id from user where id=1",User1.class);
		System.out.print(u.getName()+u.getAge()+u.getId());
	}
	public static Object getObejct(String sql,Class clazz){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Object obj = null;
		try {
			conn = jdbc_util.getConnetion();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			String[] colName = new String[count];
			for(int i=1;i<=count;i++){
				colName[i-1] = rsmd.getColumnLabel(i);
			}
			
			Method[] m = clazz.getMethods();
			while(rs.next()){
				try {
					obj = clazz.newInstance();
					for(int i=0;i<colName.length;i++){
					String col = colName[i];
					
					String methodName = "set"+colName[i];
					for(Method m1:m){
						
						if(methodName.equals(m1.getName())){
							m1.invoke(obj, rs.getObject(col));
						    }
					}
				}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			jdbc_util.realease(conn, ps, rs);
		}
		return obj;
		
	}

}
