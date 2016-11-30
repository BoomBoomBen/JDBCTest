package p11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class Jdbc_test1 {

	public static void main(String[] args) {
		int age = 30;
		String name = "''or 1";
		// 查询
		test("John");
	}

	// 查询
	static void test(String s) {
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String s1 = s;
		try {

			// 建立连接
			conn = jdbc_util.getConnetion();
			// 创建语句
			String sql = "select id,name,age,birthday from user where name= ?"; 
			ps = conn.prepareStatement(sql);
			ps.setString(1,s);
			// 执行语句
			rs = ps.executeQuery();
			// 处理结果
			while (rs.next()) {
				System.out.println(rs.getObject("id") + "\t"
						+ rs.getObject("name") + "\t" + rs.getObject("age"));
			}
		} catch (Exception e) {

			throw new CRUDException(e.getMessage(),e);
		} finally {
			jdbc_util.realease(conn, ps, rs);
		}
	}

	// 增加
	static void Insert_test(String s) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String s1 = s;
		try {

			// 建立连接
			conn = jdbc_util.getConnetion();
			// 创建语句
			st = conn.createStatement();
			// 执行语句
			int i = st.executeUpdate(s1);
			// 处理结果
			System.out.println(i);

		} catch (Exception e) {

			throw new CRUDException(e.getMessage(),e);
		} finally {
			jdbc_util.realease(conn, st, rs);
		}
	}

}
