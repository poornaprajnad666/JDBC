package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc2Ssms {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:sqlserver://10.0.2.67;databaseName=TrainingDec2023;trustServerCertificate=true";
		String user = "poornap";
		String pass = "Praj@dec23";
		Connection conn = DriverManager.getConnection(url, user, pass);

		try {
			

			String sql = "select * from empPoorna;";
//			String sql = "CREATE TABLE 	empPoorna (employee_id INT PRIMARY KEY,first_name VARCHAR(50), last_name VARCHAR(50),email VARCHAR(100),hire_date DATE,department VARCHAR(50));";
//			String sql = "INSERT INTO empPoorna (employee_id, first_name, last_name, email, hire_date,department)VALUES(9, 'dolly', 'Doe', 'dolly.doe@example.com', '2023-05-19','HR'),(10, 'dane', 'Smith', 'dane.smith@example.com', '2022-05-26','President'),(11, 'Dakota', 'Johnson', 'dakota.johnson@example.com', '2023-09-11','HR'),(12, 'Bob', 'Marle','marle.williams@example.com','2021-11-29','vice-president');";            
//			String sql = "drop table empPoorna;";
			Statement p = conn.createStatement();
			ResultSet rs = p.executeQuery(sql);


			while (rs.next()) {
//				String Title = rs.getString("Title");
//				System.out.println( Title);
				int id = rs.getInt("employee_id");
				String name = rs.getString("first_name");
				String email = rs.getString("email");
				String hire_date = rs.getString("hire_date");
				System.out.println(id + "\t\t" + name + "\t\t" + email+"\t\t" + hire_date);
			}
		}
		catch (SQLException e) {
			System.out.println(e);
		}

	}
}
