package p11;

import java.sql.*;
import java.io.*;

public class BigClob {

	public static void main(String[] args) throws IOException {
		test();

	}

	public static void test() throws IOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//ע����������������
			conn = jdbc_util.getConnetion();

			String sql = "insert into big (txt) values (?)";
			//�������
            ps=conn.prepareStatement(sql);
			File file = new File("c:\\users\\Administrator\\SendTest.java");

			Reader r = new BufferedReader(new FileReader(file));
			ps.setCharacterStream(1,r,file.length());
            //ִ�����
			int m = ps.executeUpdate();
			System.out.println(m);
			r.close();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			jdbc_util.realease(conn, ps, rs);
		}
	}

}
