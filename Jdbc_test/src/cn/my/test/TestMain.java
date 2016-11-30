package cn.my.test;

import java.util.Date;

import cn.my.dao.UserDao;
import cn.my.daofactory.DaoFactory;
import cn.my.daouser.UserDaoimpl;
import cn.my.user.User;

public class TestMain {

	public static void main(String[] args) {
		UserDao ud = DaoFactory.getInstance().getUserDao();
		
				
		
//		User u = new User();
//		u.setId(30);
//		u.setAge(30);
//		u.setName("test");
//		u.setBirthday(new Date(System.currentTimeMillis()));
//		ud.addUser(u);
		

	}

}
