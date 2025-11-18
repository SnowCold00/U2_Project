

public class Account {

    private String name;
    private int day = 0;
    private double wallet = 10000;
    String ownedStocks = "";

    public Account(String name){
        this.name = name;
    }

    public void buyStock(Object name, int amount){
        double price;
        price = Double.parseDouble(name.currentPrice());
        wallet -= price;
        ownedStocks += name + ";" + amount + ",";
    }

    public void ownedStocks(){
        String[] ownList = ownedStocks.split(",");
        for (String stock: ownList){
            String[] stockDetails = stock.split(";");
            System.out.println(stockDetails[0]);
            System.out.println(stockDetails[1]);
        }
    }

}
