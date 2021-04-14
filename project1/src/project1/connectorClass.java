package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class connectorClass {
	
	
	public List<User> listUsers() {
		List<User> listUsers = new ArrayList<>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/peoples", "root", "coolsam");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select*from students");

			while (rs.next()) {
				listUsers.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listUsers;
	}

	public void addUser(User newUser) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/peoples", "root", "coolsam");
			String name = newUser.getStudentName();
			String subject = newUser.getSubject();
			String query = "insert into students (Name,major) values (?,?)";
			statement = connect.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, subject);
			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

	public void deleteUser(int i) {

		try {
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/peoples", "root", "coolsam");

			
			String query = " delete from students where student_id = ? " ;
			PreparedStatement statement = connect.prepareStatement(query);
			statement.setInt(1, i);
			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateUser(User updatedUser) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/peoples", "root", "coolsam");
			int Id = updatedUser.getRegId();
			String name = updatedUser.getStudentName();
			String subject = updatedUser.getSubject();
			String query = "update students set Name = ? , major = ? where student_id = ? ";
			statement = connect.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, subject);
			statement.setInt(3, Id);
			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();

		}

	}

}
