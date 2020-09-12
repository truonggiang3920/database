package laptop.store.application.connection;

import laptop.store.application.CounterModel;
import laptop.store.application.LaptopStoreModel;
import laptop.store.application.StatisticModel;
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
                    .getConnection("jdbc:mysql://127.0.0.1:3306/store_cms_plusplus?characterEncoding=UTF-8&autoReconnect=true&connectTimeout=30000&socketTimeout=30000&serverTimezone=UTC",
                            "root", "truonggiang3920");
            System.out.println("SQL Connection to database established!");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            System.out.println(e);
            return;
        }
        LaptopStoreService laptopStoreService = new LaptopStoreService(connection);
        System.out.println("_________________________________Request 1_____________________________________________");
        ArrayList <LaptopStoreModel> results = laptopStoreService.searchLaptop("10000000","30000000",
                null,null,null
                ,null,null,null,null,"DESC");
        for(LaptopStoreModel laptopStoreModel : results){
            System.out.println(laptopStoreModel.toString());
        }
        System.out.println("_________________________________Request 2_____________________________________________");
        ArrayList <LaptopStoreModel> result2 = laptopStoreService.findLaptopBySold();
        for(LaptopStoreModel laptopStoreModels : result2)
        {
            System.out.println(laptopStoreModels.toString());
        }
        System.out.println("_________________________________Request 3_____________________________________________");
        ArrayList <CounterModel> result3 = laptopStoreService.getCounterByMaker();
        for (CounterModel counterModel : result3 )
        {
            System.out.println(counterModel.getMaker() + "\t" + counterModel.getQuantity());
        }
        System.out.println("_________________________________Request 4_____________________________________________");
        ArrayList <StatisticModel> result4 = laptopStoreService.getStatisticByMaker();
        for (StatisticModel statisticModel : result4)
        {
            System.out.println(statisticModel.getMaker() + "\t" + statisticModel.getSold() + "\t" + statisticModel.getTotalMoney());
        }
        System.out.println("_________________________________Request 5_____________________________________________");
        laptopStoreService.insertLaptop(7, "Laptop Lenovo Yoga S740-14IIL-81RS0036VN (14\" FHD/i5-1035G4/8GB/512GB SSD/Iris Plus/Win10/1.5 kg)",
                "https://phongvu.vn/may-tinh-xach-tay-laptop-lenovo-yoga-s740-14iil-81rs0036vn-i5-1035g4-xam-s191100012.html", "LENOVO",
                "Yoga S740-14IIL", "8GB", "Intel Core i5-1035G4", "512GB", null, "23690000", "Intel Iris Plus Graphics",
                "1920 x 1080", "14", 28);
        System.out.println("Thêm mới laptop thành công!");
        System.out.println("_________________________________Request 6_____________________________________________");
        laptopStoreService.updateSoldLatptop(1,2);
        System.out.println("Cập nhật số lượng laptop đã bán thành công!");
    }
}
