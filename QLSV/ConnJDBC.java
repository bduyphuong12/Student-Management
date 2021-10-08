package QLSV;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ConnJDBC {
	
	public static Connection getConnection() {// connection function
		Connection connection=null;
		String url="jdbc:sqlserver://DESKTOP-FCKCG6E\\SQLEXPRESS01:1433;databasename=studentmn";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(url,"sa","123456");
			Statement stmt = connection.createStatement();
		}catch(Exception ex) {
		ex.printStackTrace();
	}
		return connection;
}
	public static List<Student>findAll(){
		List<Student>studentList= new ArrayList<>();
		String query="select*from student";
		try {
			Connection connection =getConnection();
			Statement stmt= connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				Student st=new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),
						rs.getInt("gender"),rs.getString("major"),rs.getFloat("score"));
				studentList.add(st);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return studentList;
	}
	public static void insert(Student st) {
		String query="insert into student(name,age,gender,major,score) values(?,?,?,?,?)";
		try {
			Connection connection =getConnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.setString(1, st.getName());
			pstmt.setInt(2, st.getAge());
			pstmt.setInt(3, st.getGender());
			pstmt.setString(4, st.getMajor());
			pstmt.setFloat(5, st.getScore());
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void delete(Student st) {
		String query="delete from student where name='"+st.getName()+"'";
		try {
			Connection connection =getConnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void Update(Student st) {
		String query="Update student set name=?,age=?,gender=?,major=?,score=? where name='"+st.getName()+"'";
		try {
			Connection connection=getConnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.setString(1, st.getName());
			pstmt.setInt(2, st.getAge());
			pstmt.setInt(3, st.getGender());
			pstmt.setString(4, st.getMajor());
			pstmt.setFloat(5, st.getScore());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static List<Student>findByName(Student s) {
		List<Student>studentl= new ArrayList<>();
		String query="select*from student where student.name='"+s.getName()+"'";
		try {
			Connection connection =getConnection();
			Statement stmt= connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				Student st=new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),
						rs.getInt("gender"),rs.getString("major"),rs.getFloat("score"));
				studentl.add(st);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return studentl;
	}
}
