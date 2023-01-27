package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

public class Dao {

	public static boolean insertStudentToDb(Student st) {
		
		boolean f =false;
		
		//jdbc code to insert
		try {
		
		Connection con = Cp.createC();
		
		//dynamic query;
		
		String q = "insert into students(sname,sphone,scity) values(?,?,?)";
		
		// PreparedStatement for dynamic query
		
		PreparedStatement pstmt=con.prepareStatement(q);
		
		// now set the values of the params
		
		
		pstmt.setString(1,st.getStudentName());
		pstmt.setString(2,st.getStudentPhone());
		pstmt.setString(3,st.getStudentCity());
		
		//execute
		
		pstmt.executeUpdate();
		
		f=true;
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return f;
		
	}

	public static boolean deleteStudent(int userId) {
		// TODO Auto-generated method stub
		
		boolean f =false;
		
		//jdbc code to insert
		try {
		
		Connection con = Cp.createC();
		
		//dynamic query;
		
		String q = "delete from students where sid=?";
		
		// PreparedStatement for dynamic query
		
		PreparedStatement pstmt=con.prepareStatement(q);
		
		// now set the values of the params
		
		
		pstmt.setInt(1,userId);
	
		//execute
		
		pstmt.executeUpdate();
		
		f=true;
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return f;
		
		
	}

	public static void  showStudents() {
		// TODO Auto-generated method stub
		
		
		//jdbc code to insert
		try {
		
		Connection con = Cp.createC();
		
		//dynamic query;
		
		String q = "select * from students;";
		
		// Statement for static query
		
		java.sql.Statement stmt=con.createStatement();
		
		
		
		
	
	
		//execute
		
		ResultSet set = stmt.executeQuery(q);
		
		while(set.next()) {
			
			int id=set.getInt(1);
			String name=set.getString(2);
			String phone = set.getString(3);
			String city = set.getString(4);
			
			System.out.println("Id :-"+id);
			System.out.println("name :-"+name);
			System.out.println("phone :-"+phone);
			System.out.println("city :-"+city);
			System.out.println("--------------------------------");
			
		}
		
		
		
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		
	}
	
	
}
