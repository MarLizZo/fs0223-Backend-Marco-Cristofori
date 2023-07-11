package com.epicode.MainPKG;

import java.sql.SQLException;
import java.util.List;

import com.epicode.Models.Student;
import com.epicode.database.DBConnection;

public class Main {

	public static void main(String[] args) {
		try {
			DBConnection db = new DBConnection();
			
			//db.createTable();
			
			//db.createStudent();
			//db.createStudent(new Student("Umberto", "Emanuele", "M", LocalDate.of(1980, 1, 1), 8.3, 7.0, 9.6));
			//db.createStudent(new Student("Anonimo", "Anonymous", "M", LocalDate.of(1999, 5, 9), 9.8, 8.0, 10.0));
			//db.createStudent(new Student("Gildo", "Asino", "M", LocalDate.of(1992, 2, 1), 6.4, 4.0, 7.5));
			//db.createStudent(new Student("Giacomina", "Forte", "F", LocalDate.of(1988, 9, 8), 8.7, 7.5, 9.5));
			//db.createStudent(new Student("Geltrude", "Stramba", "F", LocalDate.of(1994, 3, 12), 7.7, 6.5, 8.5));
			//db.createStudent(new Student("Emanuele", "Raffreddato", "M", LocalDate.of(1986, 11, 4), 7.2, 6.0, 8.8));
			
			/* HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("name", "Marco");
			m.put("lastname", "LizZo");
			m.put("birthday", LocalDate.of(1995, 1, 1));
			m.put("avg", 9.6);
			m.put("max_vote", 10.0);
			
			db.updateStudent(1, m); */
			
			//db.deleteStudent(3);
			
			//db.getBest();
			
			List<Student> ls = db.getVoteRange(5.9, 8.9);
			if (ls.size() > 0) {
				ls.forEach(s -> System.out.println(s));
			} else {
				System.out.println("** No student found **");
			}
			
		} catch (SQLException ex) {
			System.out.println("Errore: " + ex.getMessage());
		}
	}
}

























