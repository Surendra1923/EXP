package com.dao;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class PassDetailsdao {
	public void storedetails(String uname,int age,String email,long phno,long aadhar) {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/flyway","root","pass123");
			String sel="insert into person values(?,?,?,?,?,?);";
			PreparedStatement pst=con.prepareStatement(sel);
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from person order by bid desc;");
			if(rs.next())
				pst.setInt(6, rs.getInt("bid")+1);
			else
				pst.setInt(6, 100);
			pst.setString(1,uname);
			pst.setInt(2, age);
			pst.setString(3, email);
			pst.setLong(4, phno);
			pst.setLong(5, aadhar);
			int i= pst.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
