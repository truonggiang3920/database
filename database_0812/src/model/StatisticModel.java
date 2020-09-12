package model;

public class StatisticModel {
    private String maker;
    private Integer sold;
    private String totalMoney;

    public StatisticModel() {}

    public StatisticModel(String maker, Integer total, String totalMoney) {
        this.maker = maker;
        this.sold = total;
        this.totalMoney = totalMoney;
    }

    public String getMaker() {return maker;}
    public void setMaker(String maker) {this.maker = maker;}

    public Integer getSold() {return sold;}
    public void setSold(Integer total) {this.sold = total;}

    public String getTotalMoney() {return totalMoney;}
    public void setTotalMoney(String totalMoney) {this.totalMoney = totalMoney;}
}
