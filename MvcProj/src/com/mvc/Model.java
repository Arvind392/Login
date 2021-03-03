package com.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {
	//Model M;
	static 	String id;
	static  String name;
	static int marks;

	static Connection con;
	static PreparedStatement psmt;
	String url = "jdbc:mysql://localhost:3306/student";
	String uname = "root";
	String pwd = "123456";
	static ResultSet res;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("url", "uname", "pwd");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

public void display() throws SQLException
	{
	 String s = "select * from student.stud1 where sid=?";
		psmt = con.prepareStatement(s);
		psmt.setString(1, "id");
		res = psmt.executeQuery();
		while (res.next()) {
			 id = res.getString(1);
			 name = res.getString(2);
			marks = res.getInt(3);
		}
	
		
	}
}
