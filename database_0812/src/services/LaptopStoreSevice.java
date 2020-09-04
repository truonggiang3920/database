package services;

import model.ModelLaptopStore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LaptopStoreSevice implements LaptopInterface {
    private Connection connection;

    public LaptopStoreSevice(Connection connection) {
        this.connection = connection;
    }

    @Override
    public ArrayList<ModelLaptopStore> findLaptopByPrice(long price1, long price2) {
        ArrayList<ModelLaptopStore> modelLaptopStores = new ArrayList<>();
        String query = "SELECT * FROM store_cms_plusplus.laptop WHERE price BETWEEN " + price1 + " AND " + price2 + ";";
        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery(query);
            while (data.next()) {
                ModelLaptopStore laptopStore = new ModelLaptopStore(
                        data.getString(2),
                        data.getString(3),
                        data.getString(4),
                        data.getString(5),
                        data.getString(6),
                        data.getString(7),
                        data.getString(8),
                        data.getString(9),
                        data.getFloat(10),
                        data.getString(11),
                        data.getString(12),
                        data.getFloat(13),
                        data.getInt(14));

                modelLaptopStores.add(laptopStore);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelLaptopStores;
    }

    @Override
    public ArrayList<ModelLaptopStore> findLaptopByHardDrive(String maker, String hard_drive) {
        ArrayList<ModelLaptopStore> modelLaptopDrive = new ArrayList<>();
        String query2 = "SELECT * FROM store_cms_plusplus.laptop WHERE `maker` = '" + maker + "' AND ssd " + hard_drive + ";";
        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery(query2);
            while (data.next()) {
                ModelLaptopStore laptopStore = new ModelLaptopStore(
                        data.getString(2),
                        data.getString(3),
                        data.getString(4),
                        data.getString(5),
                        data.getString(6),
                        data.getString(7),
                        data.getString(8),
                        data.getString(9),
                        data.getFloat(10),
                        data.getString(11),
                        data.getString(12),
                        data.getFloat(13),
                        data.getInt(14));

                modelLaptopDrive.add(laptopStore);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return modelLaptopDrive;

    }
}
