import java.text.DecimalFormat;

public class Stock {

    private String name;
    private double price;
    private DecimalFormat format1 = new DecimalFormat("###,###,##0.00");
    private int id;

    public Stock(String name, int id){
        this.name = name;
        price = ((int) ((Math.random()*10000)*100))/100.0;
        this.id = id;
    }

    public String priceChange(){
        int percentChange = (int) ((Math.random()*250)+1);
        price *= percentChange/100.0;
        return format1.format(price);
    }

    public void info(){
        System.out.println(name + " $" + format1.format(price));
    }

    public double currentPrice(){
        return price;
    }

    public String nameStock(){
        return name;
    }

}


