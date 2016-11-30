package cn.my.daouser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.my.dao.UserDao;
import cn.my.myexciption.DaoException;
import cn.my.user.User;

public class UserDaoimpl implements UserDao {

	
	public void addUser(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into user (id,name,age,birthday) values (?,?,?,?)";
		try {
			conn = Jdbc_util.getConnection();
			ps = conn.prepareStatement(sql);			
		    ps.setInt(1, user.getId());
			ps.setString(2, user.getName());
			ps.setInt(3, user.getAge());
			ps.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
			ps.executeUpdate();
		} catch (SQLException e) {
			
			throw new DaoException(e.getMessage(),e);
		}
		finally{			
			Jdbc_util.realease(conn, ps, rs);
		}
	

	}
	public void addUsers(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into user (id,name,age,birthday) values (?,?,?,?)";
		try {
			conn = Jdbc_util.getConnection();
			ps = conn.prepareStatement(sql);
			for(int i=0;i<3;i++){
				ps.setInt(1, user.getId()+i);
			    ps.setString(2, user.getName()+i);
			    ps.setInt(3, user.getAge()+i);
			    ps.setDate(4, new java.sql.Date(user.getBirthday().getTime()));
			    ps.addBatch();
			}
			
			ps.executeBatch();
		} catch (SQLException e) {
			
			throw new DaoException(e.getMessage(),e);
		}
		finally{
			Jdbc_util.realease(conn, ps, rs);
		}
	

	}
	public void updateUser(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update user set name=?,age=?,birthday=? where id=?";
		try {
			conn = Jdbc_util.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, user.getName());
			ps.setInt(2, user.getAge());
			ps.setDate(3, new java.sql.Date(user.getBirthday().getTime()));
			ps.setInt(4, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			
			throw new DaoException(e.getMessage(),e);
		}
		finally{
			Jdbc_util.realease(conn, ps, rs);
		}

	}

	public void deleteUser(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "delete from user where id = ?";
		try {
			conn = Jdbc_util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());			
			ps.executeUpdate();
		} catch (SQLException e) {
			
			throw new DaoException(e.getMessage(),e);
		}
		finally{
			Jdbc_util.realease(conn, ps, rs);
		}

	}

	public User getUser(int userId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = new User();
		String sql = "select id,name,age,birthday from user where id = ?";
		try {
			conn = Jdbc_util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);			
			rs = ps.executeQuery();
			while(rs.next()){
				u.setId(userId);
			    u.setName(rs.getString("name"));
			    u.setAge(rs.getInt("age"));
			    u.setBirthday(rs.getDate("birthday"));
			}
			
		} catch (SQLException e) {
			
			throw new DaoException(e.getMessage(),e);
		}
		finally{
			Jdbc_util.realease(conn, ps, rs);
		}
		return u;
	}

	public User searchUser(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = new User();
		String sql = "select id,name,age,birthday from user where name = ?";
		try {
			conn = Jdbc_util.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);			
			rs = ps.executeQuery();
			while(rs.next()){
				u.setId(rs.getInt("id"));
     			u.setName(name);
			    u.setAge(rs.getInt("age"));
			    u.setBirthday(rs.getDate("birthday"));
			}
			
		} catch (SQLException e) {
			
			throw new DaoException(e.getMessage(),e);
		}
		finally{
			Jdbc_util.realease(conn, ps, rs);
		}
		return u;
	}
//	
//	public User getUserResult() {
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		User u = new User();
//		String sql = "select id,name,age,birthday from user";
//		try {
//			conn = Jdbc_util.getConnection();
//			ps = conn.prepareStatement(sql,
//					ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//						
//			rs = ps.executeQuery();
//			rs.absolute(1);
//			u.setName(rs.getString("name"));
//			
//			rs.previous();
//			u.setName(rs.getString("name"));
//			while(rs.next()){
//				
//			    u.setName(rs.getString("name"));
//			    u.setAge(rs.getInt("age"));
//			    u.setBirthday(rs.getDate("birthday"));
//			}
//			
//		} catch (SQLException e) {
//			
//			throw new DaoException(e.getMessage(),e);
//		}
//		finally{
//			Jdbc_util.realease(conn, ps, rs);
//		}
//		return u;
//	}

}
