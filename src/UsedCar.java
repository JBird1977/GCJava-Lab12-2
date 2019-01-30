
public class UsedCar extends Car{

    private double mileage = 0.0;
    
    public UsedCar() {super();}
    
    public UsedCar (String mk, String md, int yr, double money) {
        super(mk, md, yr, money);
        this.mileage = 0.0;
     }
    
    public UsedCar (String mk, String md, int yr, double money, double miles) {
        super(mk, md, yr, money);
        this.mileage = miles;
     }
    
    
    public double mileGet() {
        return mileage;
    }


    public void mileSet(double miles) {
        this.mileage = miles;
    }


    
       
       @Override
       public String toString() {
           return String.format("%s \t %s \t %d \t $%6.2f \n", makeGet(), modelGet(), yearGet(), priceGet(), mileGet());
          }
    } //end class

    
    

