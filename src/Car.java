
public class Car {
    
    private String make;
    private String model;
    private int year;
    private double price;
    
    public Car () {
        make = "";
        model = "";
        year =  0000;
        price = 0.0;
    }
    
    public Car (String mk, String md, int yr, double money) {
        this.make = mk;
        this.model = md;
        this.year = yr;
        this.price = money;
        
        
    }
    
    public void makeSet(String mk) {
        this.make = mk;

    }
    
    public String makeGet() {
        return this.make;
    }
    
    public void modelSet(String md) {
        this.model = md;

    }
    
    public String modelGet() {
        return this.model;
    }
    
    public void yearSet(int yr) {
        this.year = yr;

    }
    
    public int yearGet() {
        return this.year;
    }
    
    public void priceSet(double money) {
        this.price = money;

    }
    
    public double priceGet() {
        return this.price;
    }
    
    @Override
    
  public String toString() {
     return String.format("%s \t %s \t %d \t $%6.2f \n", make, model, year, price);
    }
    
    

}
