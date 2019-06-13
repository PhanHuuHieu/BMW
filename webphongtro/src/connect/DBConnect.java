package connect;

import java.sql.*;
import java.sql.DriverManager;

public class DBConnect {
//
//	static String dbname="cnpm";
//	static String dbuser="root";
//	static String dbpass="3ZjuFcoBbE";
	
	public Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//conn = DriverManager.getConnection("jdbc:mysql://mysql56856-longtinh.whelastic.net/"+dbname+"?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8", dbuser, dbpass);
			conn = DriverManager.getConnection("jdbc:mysql://den1.mysql4.gear.host/cnpm","cnpm","Bb@123456");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
