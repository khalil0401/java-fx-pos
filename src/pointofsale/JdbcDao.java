/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsale;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.Cursor;

/**
 *
 * @author benchek
 */
public class JdbcDao {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/spos?useSSL=false";
    private static final String DATABASE_UESRNAME = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String DATABASE_QUERY = "SELECT * FROM tec_users WHERE username=? AND password=?";

    
    public Connection conctionfun() throws SQLException{
             Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_UESRNAME, DATABASE_PASSWORD);
return connection;
    }
    public boolean validate(String username, String password) {
        try {

            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_UESRNAME, DATABASE_PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(DATABASE_QUERY);
            
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            System.err.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
                   System.err.println(e);
        }
        return false;
    }
    public ResultSet getproduct() throws SQLException{
        Connection c =conctionfun();
       PreparedStatement p= c.prepareStatement("SELECT * FROM tec_products");
        ResultSet resultSet=p.executeQuery();
        
        return resultSet;
    }
     public ResultSet SearchProdByCodeAndName(String Name) throws SQLException{
        Connection c =conctionfun();
       PreparedStatement p= c.prepareStatement("SELECT * FROM tec_products WHERE name LIKE '%"+Name+"%' OR code LIKE '%"+Name+"%'");
        ResultSet resultSet=p.executeQuery();
        
        return resultSet;
    }
}
