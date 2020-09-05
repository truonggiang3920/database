package laptop.store.application.service;

import laptop.store.application.LaptopStoreModel;

import java.util.ArrayList;

public interface LaptopStoreInterface {
    ArrayList<LaptopStoreModel> searchLaptop(Float from_price, Float to_price, String maker, String screen_size,
                                             String ram, String cpu, String type, String card, Integer sold, String sort);
    ArrayList<LaptopStoreModel> findLaptopBySold();
}
