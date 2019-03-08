package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public Connection Connect(){
        try {
            String url = "jdbc:mysql://localhost:3306/store?serverTimezone=UTC&useSSL=false";
            String user = "root";
            String password = "9602015";

            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connection Established...");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
