package laptop.store.application.service;

import laptop.store.application.CounterModel;
import laptop.store.application.LaptopStoreModel;
import laptop.store.application.StatisticModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LaptopStoreService implements LaptopStoreInterface {
    private Connection connection;
    public LaptopStoreService(Connection connection){
        this.connection = connection;
    }


    @Override
    public ArrayList<LaptopStoreModel> searchLaptop(String from_price, String to_price,
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
            query += " AND `price` <= " + to_price + "";
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
        String query = "SELECT * FROM store_cms_plusplus.laptop ORDER BY `sold` DESC LIMIT 2 ";
        ArrayList<LaptopStoreModel> result = querySql(query);
        return result;
    }

    @Override
    public ArrayList <CounterModel> getCounterByMaker()
    {
        ArrayList <CounterModel> counterModels = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT maker, COUNT(*) AS quantity FROM store_cms_plusplus.laptop GROUP BY maker ORDER BY quantity DESC ;\n";
            ResultSet data = statement.executeQuery(query);
            while (data.next())
            {
                CounterModel counter = new CounterModel(
                    data.getString(1), data.getString(2));
                counterModels.add(counter);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return counterModels;
    }

    @Override
    public ArrayList<StatisticModel> getStatisticByMaker() {
        ArrayList <StatisticModel> statisticModels = new ArrayList<>();
        try
        {
            Statement statement = connection.createStatement();
            String query = "SELECT laptop.maker, SUM(laptop.`sold`) AS totalSold, SUM( laptop.price * laptop.`sold`) AS totalMoney FROM laptop GROUP BY maker ORDER BY totalMoney DESC ;\n";
            ResultSet data = statement.executeQuery(query);
            while (data.next())
            {
                StatisticModel statistic = new StatisticModel(
                        data.getString(1),
                        data.getInt(2),
                        data.getString(3));
                statisticModels.add(statistic);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return statisticModels;
    }

    @Override
    public void insertLaptop(Integer id, String name, String url, String maker, String type, String ram, String cpu, String ssd, String hdd, String price, String card,
                                         String screen_resolution, String screen_size, Integer sold) {
        try
        {
            Statement statement = connection.createStatement();
            String query = "INSERT IGNORE INTO store_cms_plusplus.laptop (`id`,`name`,`url`,`maker`,`type`,`ram`,`cpu`,`ssd`,`hdd`,`price`,`card`,`screen_resolution`,`screen_size`,`sold`) VALUES ('" + id + "','" + name + "','" + url + "','" + maker + "','" + type + "','" + ram + "','" + cpu + "','" + ssd + "','" + hdd + "','" + price + "','" + card + "','" + screen_resolution + "','" + screen_size + "','" + sold + "') ";
            statement.execute(query);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    public void updateSoldLatptop(Integer id, Integer sold){
        try
        {
            Statement statement = connection.createStatement();
            String query = "UPDATE store_cms_plusplus.laptop SET `sold` = `sold`+ " + sold + " WHERE `id` = " + id + ";";
            statement.execute(query);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
