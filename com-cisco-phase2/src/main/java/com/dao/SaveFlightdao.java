package com.dao;


import java.sql.Connection;

import java.util.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;


public class SaveFlightdao {
	public void saveflight(int fid,String src,String dest,long price,String arr,String dept) {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flyway","root","pass123");
			String sel="insert into flights values(?,?,?,?,?,?);";
			PreparedStatement pst=con.prepareStatement(sel);
			pst.setInt(1, fid);
			pst.setString(2, src);
			pst.setString(3, dest);
			pst.setLong(4, price);
			pst.setString(5, arr);
			pst.setString(6, dept);
			int i= pst.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
