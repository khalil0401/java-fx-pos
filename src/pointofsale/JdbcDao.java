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
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.ObservableList;
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

    public boolean InsertCustomer(String Name, String Phone, String Email) throws SQLException {
        Connection c = conctionfun();
        PreparedStatement p = c.prepareStatement("INSERT INTO tec_customers (name, phone,email)"
                + "VALUES('" + Name + "','" + Phone + "','" + Email + "')");
        boolean res = p.execute();
        return res;
    }

    public void InsertNewPayment(int CustomerId, String CustomerName, float Total, int TotalItem, int TotalQuantity, float Paid, int CreatedBy, String Note, String Comment, String Status, ObservableList<oneproduct> SaleItems) throws SQLException {
        Connection c = conctionfun();
        PreparedStatement p = c.prepareStatement("INSERT INTO tec_sales (customer_id, customer_name,grand_total,total,total_items,paid,total_quantity,created_by,note,status)"
                + "VALUES('" + CustomerId + "','" + CustomerName + "','" + Total + "','" + Total + "','" + TotalItem + "','" + Paid + "','" + TotalItem + "','" + 1 + "','" + Note + "','" + Status + "')", Statement.RETURN_GENERATED_KEYS);
        int id = p.executeUpdate();
        ResultSet res = p.getGeneratedKeys();
        res.next();
        for (int i = 0; i < SaleItems.size(); i++) {
            PreparedStatement p1 = c.prepareStatement("INSERT INTO tec_sale_items (sale_id, product_id,quantity,unit_price,cost,product_code,product_name,comment)"
                    + "VALUES('" + res.getInt(1) + "','" + SaleItems.get(i).getID() + "','" + SaleItems.get(i).getQuantity() + "','" + SaleItems.get(i).getPrice() + "','" + SaleItems.get(i).getCost() + "','" + SaleItems.get(i).getCode() + "','" + SaleItems.get(i).getName() + "','" + Comment + "')");
            p1.execute();
        }
    }

    public ResultSet GetSales() throws SQLException {
        Connection c = conctionfun();
        PreparedStatement ps = c.prepareStatement("SELECT * from tec_sales");
        ResultSet res = ps.executeQuery();
        return res;
    }

    public void InsertUser(int Group, String FName, String LName, String Phone, String Gender, String Email, String UName, String Password, int Status) throws SQLException {
        Connection c = conctionfun();
        PreparedStatement ps = c.prepareStatement("INSERT INTO tec_users (group_id,first_name,last_name,phone,gender,email,username,password,active)"
                + "VALUES ('" + Group + "','" + FName + "','" + LName + "','" + Phone + "','" + Gender + "','" + Email + "','" + UName + "','" + Password + "','" + Status + "')");
        ps.executeUpdate();

    }

    public ResultSet GetUsers() throws SQLException {
        Connection c = conctionfun();
        PreparedStatement preparedStatement = c.prepareStatement("SELECT * from tec_users");
        ResultSet res =preparedStatement.executeQuery();
        return res;
    }
}
