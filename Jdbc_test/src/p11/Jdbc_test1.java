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
		// ��ѯ
		test("John");
	}

	// ��ѯ
	static void test(String s) {
		Connection conn = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String s1 = s;
		try {

			// ��������
			conn = jdbc_util.getConnetion();
			// �������
			String sql = "select id,name,age,birthday from user where name= ?"; 
			ps = conn.prepareStatement(sql);
			ps.setString(1,s);
			// ִ�����
			rs = ps.executeQuery();
			// ������
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

	// ����
	static void Insert_test(String s) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String s1 = s;
		try {

			// ��������
			conn = jdbc_util.getConnetion();
			// �������
			st = conn.createStatement();
			// ִ�����
			int i = st.executeUpdate(s1);
			// ������
			System.out.println(i);

		} catch (Exception e) {

			throw new CRUDException(e.getMessage(),e);
		} finally {
			jdbc_util.realease(conn, st, rs);
		}
	}

}
