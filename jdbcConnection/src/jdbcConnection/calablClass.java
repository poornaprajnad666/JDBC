package jdbcConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class calablClass {
	public static void main(String[] args) {
		String url = "jdbc:sqlserver://10.0.2.67;databaseName=TrainingDec2023;trustServerCertificate=true";
		String user = "poornap";
		String pass = "Praj@dec23";
        
        // SQL query to call the stored procedure
        String sql = "exec emp_all";
        
        try (
            // Establish connection to the database
            Connection conn = DriverManager.getConnection(url, user, pass);
            
            // Prepare the call to the stored procedure
            CallableStatement callableStatement = conn.prepareCall(sql);
        ) {
            // Set input parameters (if any)
            
            
            // Execute the stored procedure
        	ResultSet rs =callableStatement.executeQuery();
            
        	while (rs.next()) {
//				String Title = rs.getString("Title");
//				System.out.println( Title);
				int id = rs.getInt("employee_id");
				String name = rs.getString("first_name");
				String email = rs.getString("email");
				String hire_date = rs.getString("hire_date");
				System.out.println(id + "\t\t" + name + "\t\t" + email + "\t\t" + hire_date);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}