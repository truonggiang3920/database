package model;

public class LaptopStoreModel {
    private String maker;
    private String type;
    private String ram;
    private String cpu;
    private String price;
    private String card;
    private Float screen_size;
    private Integer sold;

    public LaptopStoreModel() {}

    public LaptopStoreModel(String maker, String type,
                            String ram, String cpu,
                            String price, String card,
                            Float screen_size, Integer sold) {
        this.maker = maker;
        this.type = type;
        this.ram = ram;
        this.cpu = cpu;
        this.price = price;
        this.card = card;
        this.screen_size = screen_size;
        this.sold = sold;
    }

    public String getMaker() {return maker;}
    public void setMaker(String maker) {this.maker = maker;}

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    public String getRam() {return ram;}
    public void setRam(String ram) {this.ram = ram;}

    public String getCpu() {return cpu;}
    public void setCpu(String cpu) {this.cpu = cpu;}

    public String getPrice() {return price;}
    public void setPrice(String price) {this.price = price;}

    public String getCard() {return card;}
    public void setCard(String card) {this.card = card;}

    public Float getScreen_size() {return screen_size;}
    public void setScreen_size(Float screen_size) {this.screen_size = screen_size;}

    public Integer getSold() {return sold;}
    public void setSold(Integer sold) {this.sold = sold;}

    @Override
    public String toString() {
        return "ModelLaptopBase{" +
                ", maker='" + maker + '\'' +
                ", type='" + type + '\'' +
                ", ram='" + ram + '\'' +
                ", cpu='" + cpu + '\'' +
                ", price=" + price +
                ", card='" + card + '\'' +
                ", screen_size=" + screen_size +
                ", sold=" + sold +
                '}';
    }
}
