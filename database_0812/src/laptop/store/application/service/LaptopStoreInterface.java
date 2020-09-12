package laptop.store.application.service;


import laptop.store.application.CounterModel;
import laptop.store.application.LaptopStoreModel;
import laptop.store.application.StatisticModel;


import java.util.ArrayList;

public interface LaptopStoreInterface {
    ArrayList <LaptopStoreModel> searchLaptop(String from_price, String to_price, String maker, String screen_size,
                                             String ram, String cpu, String type, String card, Integer sold, String sort);
    ArrayList <LaptopStoreModel> findLaptopBySold();
    ArrayList <CounterModel> getCounterByMaker();
    ArrayList <StatisticModel> getStatisticByMaker();
    void insertLaptop(Integer id, String name, String url, String maker, String type, String ram, String cpu, String ssd, String hdd, String price, String card,
                      String screen_resolution, String screen_size, Integer sold);
    void updateSoldLatptop(Integer id, Integer sold);
}
