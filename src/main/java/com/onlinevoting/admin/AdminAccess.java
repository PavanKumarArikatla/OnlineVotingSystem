package com.onlinevoting.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminAccess 
{
	Connection con;
	Statement st;
	PreparedStatement pst;
	
	public boolean checkadmin(String name, String password) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voter", "root", "........");
		st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from admin");
		rs.next();
		String admin = rs.getString(1);
		String adminpassword = rs.getString(2);
		if(admin.equalsIgnoreCase(name) && adminpassword.equalsIgnoreCase(password))
		{
			return true;
		}else
			return false;
		
	}
	
	public ArrayList<String> checkVotersList() throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voter", "root","........");
		st = con.createStatement();
		ResultSet rs = st.executeQuery("Select name from vote");
		ArrayList<String> names = new ArrayList<>();
		while(rs.next())
		{
			System.out.println(rs.getString(1));

			names.add(rs.getString(1));
		}
		return names;
	}
	public ArrayList<String> getVoted() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voter", "root", "........");
		st = con.createStatement();
		ResultSet rs = st.executeQuery("select name from vote where status='voted'");
		ArrayList<String> name = new ArrayList<>();
		while(rs.next())
		{
			name.add(rs.getString(1));
		}
		return name;
	}
	public ArrayList<String> getUnVoted() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voter", "root", "........");
		st = con.createStatement();
		ResultSet rs = st.executeQuery("select name from vote where status is NULL");
		ArrayList<String> namess = new ArrayList<>();
		while(rs.next())
		{
			namess.add(rs.getString(1));
		}
		return namess;
	}
	public boolean remove(String votername) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voter", "root", "........");
		pst = con.prepareStatement("delete from vote where name=?");
		pst.setString(1, votername);
		return pst.execute();

	}
}
