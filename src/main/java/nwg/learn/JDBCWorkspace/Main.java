package nwg.learn.JDBCWorkspace;

import java.sql.*;

public class Main {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		StudentDataAccess stu = new StudentDataAccess();
		stu.getAllData();
		
		stu.insertStudent(7, "Abella Nancy", "F", 2.95);
	}
}
