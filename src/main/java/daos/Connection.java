package daos;

import com.mysql.jdbc.Driver;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    public static final String URL = "mysql://localhost:5432/cars";
    public static final String USER = "testUser";
    public static final String PASS = "testPass";


    public static Connection getConnection()    {
        try{
            DriverManager.registerDriver(new Driver());
            return (Connection) DriverManager.getConnection(URL, USER, PASS);
        }   catch (SQLException e)  {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public static void main(String[] args)  {
        Connection connection = Connection.getConnection();
    }



}
