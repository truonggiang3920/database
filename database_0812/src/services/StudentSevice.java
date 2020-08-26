package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentSevice {
    private Connection connection;

    public StudentSevice(Connection connection) {this.connection = connection;}

    public StudentSevice() {

    }

    public void getPriceLaptop()
    {
        String query;
        query = "SELECT * FROM laptop WHERE price < 30000000 AND price > 10000000";
        try{
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery(query);
            while (data.next())
            {
                String name = data.getString(2);
                String price = data.getString(10);
                System.out.println(name + " Giá bán:" + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getMakerLaptop(String makerInput)
    {
        String query = "SELECT * FROM laptop WHERE maker = '" + makerInput +"'";
        try{
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery(query);
            while (data.next())
            {
                String name = data.getString(2);
                String maker = data.getString(4);
                System.out.println(name + " Tên nhà sản xuất:" + maker);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getSsdLaptop(String ssdLaptop)
    {
        String query = "SELECT * FROM laptop WHERE ssd OR hdd";
        try{
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery(query);
            while (data.next())
            {
                String name = data.getString(2);
                String ssd = data.getString(8);
                String hdd = data.getString(9);
                System.out.println(name + " ổ cứng hhd:" + hdd);
                System.out.println(name + " Ổ cứng ssd:" + ssd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
