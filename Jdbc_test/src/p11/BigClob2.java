package p11;
import java.io.*;
import java.sql.*;
public class BigClob2 {

	public static void main(String[] args) throws IOException {
		// TODO �Զ����ɵķ������
		test();

	}
	public static void test() throws IOException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = jdbc_util.getConnetion();
			String sql = "select txt from big";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Clob clob= rs.getClob(1);
				Reader r = clob.getCharacterStream();
				File file = new File("c:\\jdbc.java");
				Writer w = new BufferedWriter(new FileWriter(file));
				char[] buff = new char[1024];
				int len = 0;
				while((len = r.read(buff))!=-1);{
				//System.out.println(rs.getString("txt"));
				   w.write(buff,0,buff.length);
				}
				r.close();
				w.close();
			};
			
			
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally{
			jdbc_util.realease(conn, ps, rs);
		}
	}

}
