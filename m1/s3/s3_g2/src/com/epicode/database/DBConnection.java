package com.epicode.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.epicode.Models.Student;

public class DBConnection {
	
	private String path = "jdbc:postgresql://localhost:5432/jdbcpractice";
	Statement state;
	
	public DBConnection() throws SQLException {
		Connection con = DriverManager.getConnection(path, "postgres", "root");
		state = con.createStatement();
		System.out.println("** > Database Connected < **");
	}
	
	public void createTable() throws SQLException {
		String query = "CREATE TABLE IF NOT EXISTS school_students("
				+ "id SERIAL PRIMARY KEY,"
				+ "name VARCHAR NOT NULL," 
				+ "lastname VARCHAR NOT NULL,"
				+ "gender VARCHAR NOT NULL,"
				+ "birthday DATE NOT NULL,"
				+ "avg DECIMAL DEFAULT 0.0,"
				+ "min_vote DECIMAL DEFAULT 0.0,"
				+ "max_vote DECIMAL DEFAULT 0.0" + ");";
		state.executeUpdate(query);
		System.out.println("** Table created **");
	}
	
	public void createStudent() throws SQLException {
		String query = "INSERT INTO school_students ("
				+ "name, lastname, gender, birthday, avg, min_vote, max_vote) "
				+ "VALUES (" + 
				"'Marco', 'Cristofori', 'M', '1995-06-04', 9.2, 8.0, 10.0);";
		state.executeUpdate(query);
		System.out.println("** Student created **");
	}
	
	public void createStudent(Student st) throws SQLException {
		String query = "INSERT INTO school_students ("
				+ "name, lastname, gender, birthday, avg, min_vote, max_vote) "
				+ "VALUES (" + 
				" '"+st.getName()+"', '"+st.getLastname()+"', '"+st.getGender()+"', '"+st.getBirthday()+"', "
						+ " '"+st.getAvg()+"', '"+st.getMin_vote()+"', '"+st.getMax_vote()+"' )";
		state.executeUpdate(query);
		System.out.println("** Student created **");
	}
	
	public void updateStudent(int id, HashMap<String, Object> s) throws SQLException {
		String name = s.containsKey("name") ? (String) s.get("name") : null;
		String lastname = s.containsKey("lastname") ? (String) s.get("lastname") : null;
		String gender = s.containsKey("gender") ? (String) s.get("gender") : null;
		LocalDate birthday = s.containsKey("birthday") ? (LocalDate) s.get("birthday") : null;
		double avg = s.containsKey("avg") ? (double) s.get("avg") : -1;
		double min_vote = s.containsKey("min_vote") ? (double) s.get("min_vote") : -1;
		double max_vote = s.containsKey("max_vote") ? (double) s.get("max_vote") : -1;
		
		String set = "";
		if (name != null) set += "name = '" + s.get("name") + "', "; 
		if (lastname != null) set += "lastname = '" + s.get("lastname") + "', ";
		if (gender != null) set += "gender = '" + s.get("gender") + "', ";
		if (birthday != null) set += "birthday = '" + s.get("birthday") + "', ";
		if (avg >= 0) set += "avg = " + s.get("avg") + ", ";
		if (min_vote >= 0) set += "min_vote = " + s.get("min_vote") + ", ";
		if (max_vote >= 0) set += "max_vote = " + s.get("max_vote") + ", ";
		
		String final_queryset = set.substring(0, set.lastIndexOf(","));
		System.out.println(final_queryset);
		
		String query = "UPDATE school_students SET " + 
				final_queryset
				+ " WHERE id = "+id+";";
		
		System.out.println(query);
		state.executeUpdate(query);
		System.out.println("** Student updated **");
	}
	
	public void deleteStudent(int id) throws SQLException {
		String search = "SELECT * FROM school_students WHERE id = " + id;
		ResultSet rs = state.executeQuery(search);
		
		if (rs.next()) {
			String query = "DELETE FROM school_students WHERE id = " + id;
			state.executeUpdate(query);
			System.out.println("** User deleted from Database **");
		} else {
			System.out.println("** No User found with id " + id + " **");
		}
	}
	
	public void getBest() throws SQLException {
		String search = "SELECT * FROM school_students ORDER BY avg DESC";
		ResultSet res = state.executeQuery(search);
		if (res.next()) {
			Student outSt = new Student(res.getInt("id"), res.getString("name"), res.getString("lastname"), 
				res.getString("gender"), LocalDate.parse(res.getString("birthday")), res.getDouble("avg"), 
				res.getDouble("min_vote"), res.getDouble("max_vote"));
			System.out.println(outSt.toString());
		}
	}
	
	public List<Student> getVoteRange(double min, double max) throws SQLException {
		List<Student> ls = new ArrayList<Student>();
		String query = "SELECT * FROM school_students WHERE min_vote > " + 
				min + " AND max_vote < " + max + ";";
		ResultSet res = state.executeQuery(query);
		while (res.next()) {
			ls.add(new Student(res.getInt("id"), res.getString("name"), res.getString("lastname"), 
				res.getString("gender"), LocalDate.parse(res.getString("birthday")), res.getDouble("avg"), 
				res.getDouble("min_vote"), res.getDouble("max_vote")));
		}
		return ls;
	}
}


























