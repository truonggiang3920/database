package model;

public class ModelLaptopStore {
    private String name;
    private String url;
    private String maker;
    private String type;
    private String ram;
    private String cpu;
    private String ssd;
    private String hdd;
    private Float price;
    private String card;
    private String screen_resolution;
    private Float screen_size;
    private Integer sold;

    public ModelLaptopStore() {}

    public ModelLaptopStore(String name, String url, String maker, String type,
                            String ram, String cpu, String ssd, String hdd,
                            Float price, String card, String screen_resolution,
                            Float screen_size, Integer sold) {
        this.name = name;
        this.url = url;
        this.maker = maker;
        this.type = type;
        this.ram = ram;
        this.cpu = cpu;
        this.ssd = ssd;
        this.hdd = hdd;
        this.price = price;
        this.card = card;
        this.screen_resolution = screen_resolution;
        this.screen_size = screen_size;
        this.sold = sold;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getUrl() {return url;}
    public void setUrl(String url) {this.url = url;}

    public String getMaker() {return maker;}
    public void setMaker(String maker) {this.maker = maker;}

    public String getType() {return type;}
    public void setType(String type) {this.type = type;}

    public String getRam() {return ram;}
    public void setRam(String ram) {this.ram = ram;}

    public String getCpu() {return cpu;}
    public void setCpu(String cpu) {this.cpu = cpu;}

    public String getSsd() {return ssd;}
    public void setSsd(String ssd) {this.ssd = ssd;}

    public String getHdd() {return hdd;}
    public void setHdd(String hdd) {this.hdd = hdd;}

    public Float getPrice() {return price;}
    public void setPrice(Float price) {this.price = price;}

    public String getCard() {return card;}
    public void setCard(String card) {this.card = card;}

    public String getScreen_resolution() {return screen_resolution;}
    public void setScreen_resolution(String screen_resolution) {this.screen_resolution = screen_resolution; }

    public Float getScreen_size() {return screen_size;}
    public void setScreen_size(Float screen_size) {this.screen_size = screen_size;}

    public Integer getSold() {return sold;}
    public void setSold(Integer sold) {this.sold = sold;}

    @Override
    public String toString() {
        return "ModelLaptopStore{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", maker='" + maker + '\'' +
                ", type='" + type + '\'' +
                ", ram='" + ram + '\'' +
                ", cpu='" + cpu + '\'' +
                ", ssd='" + ssd + '\'' +
                ", hdd='" + hdd + '\'' +
                ", price=" + price +
                ", card='" + card + '\'' +
                ", screen_resolution='" + screen_resolution + '\'' +
                ", screen_size=" + screen_size +
                ", sold=" + sold +
                '}';
    }
}
