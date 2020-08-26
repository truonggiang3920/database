package vn.plusplus.db;

import services.StudentSevice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("-------- MySQL JDBC Connection Demo ------------");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
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

            StudentSevice studentSevice = new StudentSevice(connection);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Xin mời nhập hãng Laptop: ");
            String makerr = scanner.nextLine();
            studentSevice.getPriceLaptop();
            studentSevice.getMakerLaptop(makerr);
            System.out.print("Xin mời nhập tên ổ cứng: ");
            String hardDrive = scanner.nextLine();
            studentSevice.getSsdLaptop(hardDrive);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
