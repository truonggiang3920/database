package laptop.store.application;

public class CounterModel {
    private String maker;
    private String quantity;

    public CounterModel() {}

    public CounterModel(String maker, String quantity) {
        this.maker = maker;
        this.quantity = quantity;
    }

    public String getMaker() {return maker;}
    public void setMaker(String maker) {this.maker = maker;}

    public String getQuantity() {return quantity;}
    public void setQuantity(String quantity) {this.quantity = quantity;}
}
