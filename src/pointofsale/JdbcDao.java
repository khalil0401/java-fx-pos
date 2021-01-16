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
import java.util.ArrayList;
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

    public Connection conctionfun() throws SQLException {
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

    public ResultSet getproduct() throws SQLException {
        Connection c = conctionfun();
        PreparedStatement p = c.prepareStatement("SELECT * FROM tec_products");
        ResultSet resultSet = p.executeQuery();

        return resultSet;
    }

    public ResultSet SearchProdByCodeAndName(String Name) throws SQLException {
        Connection c = conctionfun();
        PreparedStatement p = c.prepareStatement("SELECT * FROM tec_products WHERE name LIKE '%" + Name + "%' OR code LIKE '%" + Name + "%'");
        ResultSet resultSet = p.executeQuery();

        return resultSet;
    }

    public void InsertProducts(String Name, float Price, int Quantity, String Code, int Category, String Type, float Cost, int Alart_Quantity, String Image, String Details) throws SQLException {
        Connection c = conctionfun();
        System.err.println("INSERT INTO tec_products (code, name,category_id,price,image,cost,quantity,type,details,alert_quantity) "
                + "VALUES('" + Code + "','" + Name + "','" + Category + "','" + Price + "','" + Image + "','" + Cost + "','" + Quantity + "','" + Type + "','" + Details + "','" + Alart_Quantity + "')");
        PreparedStatement p = c.prepareStatement("INSERT INTO tec_products (code, name,category_id,price,image,cost,quantity,type,details,alert_quantity) "
                + "VALUES('" + Code + "','" + Name + "','" + Category + "','" + Price + "','" + Image + "','" + Cost + "','" + Quantity + "','" + Type + "','" + Details + "','" + Alart_Quantity + "')");
        p.execute();
    }

    public ResultSet GetCat() throws SQLException {
        Connection c = conctionfun();
        PreparedStatement p = c.prepareStatement("SELECT * FROM tec_categories");
        ResultSet resultSet = p.executeQuery();

        return resultSet;
    }

    public boolean InsertCat(String name, String Code, String Image) throws SQLException {
        Connection c = conctionfun();
        PreparedStatement p = c.prepareStatement("INSERT INTO tec_categories (code, name,image)"
                + "VALUES('" + Code + "','" + name + "','" + Image + "')");
        boolean res = p.execute();
        return res;
    }

    public ResultSet GetCusteomer() throws SQLException {
        Connection c = conctionfun();
        PreparedStatement p = c.prepareStatement("SELECT * FROM tec_customers");
        ResultSet resultSet = p.executeQuery();

        return resultSet;
    }

    public boolean InsertCustomer(String Name, String Phone,String Email) throws SQLException {
        Connection c = conctionfun();
        PreparedStatement p = c.prepareStatement("INSERT INTO tec_customers (name, phone,email)"
                + "VALUES('" + Name + "','" + Phone + "','" + Email + "')");
        boolean res = p.execute();
        return res;
    }
    public void InsertNewPayment(int CustomerId,String CustomerName,float Total,int TotalItem,int TotalQuantity,float Paid,int CreatedBy,String Note,String Status,ArrayList<oneproduct> SaleItems){
        
        
    }
}
