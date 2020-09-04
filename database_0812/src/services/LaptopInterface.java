package services;

import model.ModelLaptopStore;

import java.util.ArrayList;
import java.util.List;

public interface LaptopInterface {
    ArrayList<ModelLaptopStore> findLaptopByPrice(long price1, long price2);
    ArrayList<ModelLaptopStore> findLaptopByHardDrive(String maker, String hard_drive);
}
