package laptop.store.application.connection;

import laptop.store.application.LaptopStoreModel;
import laptop.store.application.service.LaptopStoreService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
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
        Scanner scanner = new Scanner(System.in);
        LaptopStoreService laptopStoreService = new LaptopStoreService(connection);
        ArrayList<LaptopStoreModel> result = laptopStoreService.searchLaptop(1000f, null, "APPLE",
                null, null,null, null, null, 50, "DESC");
        for (LaptopStoreModel laptopStoreModel : result)
        {
            laptopStoreModel.toString();
        }
        System.out.println("-------------------------------------------------------------------");
        List<LaptopStoreModel> result2 = laptopStoreService.findLaptopBySold();
        for(LaptopStoreModel laptopStoreModels : result)
        {
            laptopStoreModels.toString();
        }
    }
}
