package laptop.store.application.service;

import laptop.store.application.LaptopStoreModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LaptopStoreService implements LaptopStoreInterface {
    private Connection connection;
    public LaptopStoreService(Connection connection){
        this.connection = connection;
    }


    @Override
    public ArrayList<LaptopStoreModel> searchLaptop(Float from_price, Float to_price,
                                                    String maker, String screen_size,
                                                    String ram, String cpu, String type,
                                                    String card, Integer sold, String sort) {
        String query = "SELECT * FROM store_cms_plusplus.laptop WHERE TRUE";
        if(from_price != null)
        {
            query += " AND `price` >= " + from_price + "";
        }
        if (to_price != null)
        {
            query += " AND `price` = " + to_price + "";
        }
        if(maker != null)
        {
            query += " AND `maker` LIKE '%" + maker + "%'";
        }
        if (screen_size != null)
        {
            query += " AND `screen_size` LIKE '%" + screen_size + "%'";
        }
        if(ram != null)
        {
            query += " AND `ram` LIKE '%" + ram + "%'";
        }
        if (cpu != null)
        {
            query += " AND `cpu` LIKE '%" + cpu + "%'";
        }
        if(type != null)
        {
            query += " AND `type` LIKE '%" + type + "%'";
        }
        if (card != null)
        {
            query += "AND `card` LIKE '%" + card + "%'";
        }
        if (sold != null) {
            query += " AND `sold` LIKE '%" + sold + "%' ";
        }
        if(sort != null)
        {
            if (sort.equals("DESC"))
            {
                query += " ORDER BY `price` DESC;";
            }
            else
            {
                query += " ORDER BY `price` ASC;";
            }
        }
        System.out.println(query);
        ArrayList <LaptopStoreModel> result = querySql(query);
        return result;

    }
    public ArrayList<LaptopStoreModel> querySql(String sql) {
        ArrayList<LaptopStoreModel> laptopStoreModels = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery(sql);
            while (data.next()) {
                LaptopStoreModel laptopModel = new LaptopStoreModel(
                        data.getString(4),
                        data.getString(5),
                        data.getString(6),
                        data.getString(7),
                        data.getString(10),
                        data.getString(11),
                        data.getFloat(13),
                        data.getInt(14));
                laptopStoreModels.add(laptopModel);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return laptopStoreModels;

    }

    @Override
    public ArrayList<LaptopStoreModel> findLaptopBySold() {
        String sql = "SELECT * FROM store_cms_plusplus.laptop ORDER BY `sold` DESC LIMIT 2";
        ArrayList<LaptopStoreModel> result = querySql(sql);
        return result;
    }
}
