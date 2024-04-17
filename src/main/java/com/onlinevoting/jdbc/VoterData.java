package com.onlinevoting.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class VoterData {
	private String name;
	private int age;
	private String mobile;

	public VoterData() {
		super();
	}

	public VoterData(String name, int age, String mobile) {
		this.name = name;
		this.age = age;
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "VoterData [name=" + name + ", age=" + age + ", mobile=" + mobile + "]";
	}

	HashMap<String, String> map = new HashMap<>();

	public boolean checkName(String name, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Voter", "root", "........");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from vote");
			while (rs.next()) {
				map.put(rs.getString(2), rs.getString(3));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getKey().equals(name) && entry.getValue().equalsIgnoreCase(password))
				return true;
		}
		
		return false;
	}

	public String getDetails(String name, String password) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Voter", "root", "........");
		PreparedStatement st = con.prepareStatement("select * from vote where name=? and password = ?");
		st.setString(1, name);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		rs.next();
		VoterData voterData = new VoterData();
		voterData.setName(name);
		voterData.setAge(rs.getInt(4));
		voterData.setMobile(rs.getNString(5));

		return name + "," + voterData.getAge() + "," + voterData.getMobile();
	}

	public boolean getstatus(String myname) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Voter", "root", "........");
		PreparedStatement st = con.prepareStatement("select * from vote where name=?");
		st.setString(1, myname);
		ResultSet rs = st.executeQuery();
		rs.next();
		if (rs.getString(6) == null) {
			return false;
		} else
			return true;

	}
	
	public boolean checkStatus(String name) throws ClassNotFoundException, SQLException
	{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voter","root","........");
			PreparedStatement st = con.prepareStatement("update vote set status='voted' where name=?");
			st.setString(1, name);
			if(st.executeUpdate() == 1)
			{
				return true;
			}
			else
				return false;	
	}
	
}
