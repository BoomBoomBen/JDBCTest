package cn.my.daofactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cn.my.dao.UserDao;

public class DaoFactory {
       private static UserDao ud = null;
       private static DaoFactory instance = new DaoFactory();
       private DaoFactory(){
    	  
    	   try {
    		   Properties pp = new Properties();
    	       InputStream is = DaoFactory.class.
    			   getClassLoader().getResourceAsStream("daoimp.properties");
			   pp.load(is);
			   String userDaoimp = pp.getProperty("DaoUserimp");
			   Class calzz = Class.forName(userDaoimp);
			   ud = (UserDao)calzz.newInstance();
			   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ExceptionInInitializerError(e);
		}
       }
       public static DaoFactory getInstance(){
    	   return instance;
       }
       public static UserDao getUserDao(){
    	   return ud;
       }
}
