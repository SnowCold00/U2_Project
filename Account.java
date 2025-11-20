import java.text.DecimalFormat;

public class Account {

    private String name;
    private int day = 0;
    private double wallet = 10000;
    private String ownedStocks = "";
    DecimalFormat format1 = new DecimalFormat("$###,###,##0.00");

    public Account(String name){
        this.name = name;
    }

    public void buyStock(Stock name, int amount){
        double price = name.currentPrice();
        wallet -= price * amount;
        String[] ownList = ownedStocks.split(",");
        for (String stock : ownList) {
            String[] stockDetails = stock.split(";");
            if ((name + "") == stockDetails[0]) {
                ownedStocks += name.nameStock() + ";" + amount + ",";
                break;
            }

        }
        ownedStocks += name.nameStock() + ";" + amount + ",";
    }

    public void sellStock(Stock name, int amount) {
        double price = name.currentPrice();
        wallet += price * amount;
        String[] ownList = ownedStocks.split(",");
        for (String stock : ownList) {
            String[] stockDetails = stock.split(";");
            if ((name + "") == stockDetails[0]) {
                if ((Integer.parseInt(stockDetails[1]) - amount) >= 0) {
                    stockDetails[1] = String.valueOf(Integer.parseInt(stockDetails[1]) - amount);
                } else {
                    System.out.println("You don't own that many shares. ");
                }
            }

        }
    }

    public void ownedStocks(){
        String[] ownList = ownedStocks.split(",");
        for (String stock: ownList){
            String[] stockDetails = stock.split(";");
            System.out.println(stockDetails[0]);
            System.out.println(stockDetails[1]);
        }
    }

    public void walletAmount(){
        System.out.println(format1.format(wallet));
    }

}