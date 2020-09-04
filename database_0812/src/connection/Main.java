package connection;

import com.sun.deploy.model.LocalApplicationProperties;
import model.ModelLaptopStore;
import services.LaptopInterface;
import services.LaptopStoreSevice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static <List> void main(String[] args) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }
        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/store_cms_plusplus" +
                                    "?characterEncoding=UTF-8&autoReconnect=true&connectTimeout=30000&socketTimeout=30000&serverTimezone=UTC\n",
                            "root", "truonggiang3920");
            System.out.println("SQL Connection to database established!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        LaptopStoreSevice laptopStoreSevice = new LaptopStoreSevice(connection);
        System.out.println("Laptop có giá từ 10 triệu đến 40 triệu là: ");
        ArrayList<ModelLaptopStore> modelLaptopStoresPrice = laptopStoreSevice.findLaptopByPrice(10000000l, 40000000l);
        for (ModelLaptopStore moderLaptopPrice : modelLaptopStoresPrice) {
            System.out.println(moderLaptopPrice.toString());
        }
        ArrayList<ModelLaptopStore> modelLaptopStoresDrive = laptopStoreSevice.findLaptopByHardDrive("APPLE","");
        System.out.println("Laptop có tên và ổ cứng theo yêu cầu là: ");
        for (ModelLaptopStore modelLaptopDrive: modelLaptopStoresDrive)
        {
            System.out.println(modelLaptopDrive.toString());
        }
    }
}
