import java.text.DecimalFormat;

public class Stock {

    private String name;
    private double price;
    DecimalFormat format1 = new DecimalFormat("###,###,##0.00");

    public Stock(String name, double price){ //Plan to make both of these random generated, if I have time.
        this.name = name;
        this.price = price;
    }

    public String priceChange(){
        int percentChange = (int) ((Math.random()*250)+1);
        price *= percentChange/100.0;
        return format1.format(price);
    }

    public double sell(){
        return price;
    }

    public void info(){
        System.out.println(name + " $" + format1.format(price));
    }

}


