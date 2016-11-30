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
			//注册驱动，建立连接
			conn = jdbc_util.getConnetion();

			String sql = "insert into big (txt) values (?)";
			//创建语句
            ps=conn.prepareStatement(sql);
			File file = new File("c:\\users\\Administrator\\SendTest.java");

			Reader r = new BufferedReader(new FileReader(file));
			ps.setCharacterStream(1,r,file.length());
            //执行语句
			int m = ps.executeUpdate();
			System.out.println(m);
			r.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			jdbc_util.realease(conn, ps, rs);
		}
	}

}
