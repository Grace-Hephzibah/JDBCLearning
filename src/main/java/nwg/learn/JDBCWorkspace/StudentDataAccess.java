package nwg.learn.JDBCWorkspace;

import java.sql.*;

public class StudentDataAccess{
	Connection con = null;
	
	public StudentDataAccess() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.OracleDriver");
			
	    String url = "jdbc:oracle:thin:@localhost:1521:xe";
	    String username = "system";
	    String password = "asdf";
	    con = DriverManager.getConnection(url, username, password);
	}
	
	public void printResultSetAll(ResultSet rs) throws SQLException{
		while(rs.next()) {
			System.out.println("Id: "+ rs.getInt(1));
			System.out.println("Name: "+ rs.getString(2));
			System.out.println("Gender: "+ rs.getString(3));
			System.out.println("GPA: "+ rs.getDouble(4));
			System.out.println();
		}
	}
	
	public void getAllData() throws SQLException{
		Statement st = this.con.createStatement();
		String sql = "Select * from student";
        ResultSet rs = st.executeQuery(sql);
        this.printResultSetAll(rs);
	}
	
	public void insertStudent(int id, String name, String gender, double gpa) throws SQLException {
		String sql = "INSERT INTO student (id, name, gender, gpa) VALUES (?, ?, ?, ?)";

		PreparedStatement pstmt = this.con.prepareStatement(sql);    
		pstmt.setInt(1, id);
	    pstmt.setString(2, name);
	    pstmt.setString(3, gender);
	    pstmt.setDouble(4, gpa);
	    
	    int rowsAffected = pstmt.executeUpdate();
	    System.out.println("Number of rows affected : " + rowsAffected);
	    if (rowsAffected > 0) {
	    	System.out.println("Student inserted successfully.");
	    } else {
	        System.out.println("Failed to insert student.");
	    }
	}
}
