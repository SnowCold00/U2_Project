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
        if (wallet < price * amount){
            System.out.println("You don't have enough money to but that many shares. ");
            return;
        }
        wallet -= price * amount;
        String[] ownList = ownedStocks.split(",");
        for (String stock : ownList) {
            String[] stockDetails = stock.split(";");
            if ((name.nameStock()).equals( stockDetails[0])) {
                int loc1 = ownedStocks.indexOf(stockDetails[0]);
                ownedStocks = (ownedStocks.substring(0,loc1+ stockDetails[0].length()+1) + (Integer.parseInt(stockDetails[1]) + amount) + ownedStocks.substring(loc1+stock.length()));
                return;
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
            if ((name.nameStock()).equals( stockDetails[0])) {
                if ((Integer.parseInt(stockDetails[1]) - amount) >= 0) {
                    int loc1 = ownedStocks.indexOf(stockDetails[0]);
                    ownedStocks = (ownedStocks.substring(0,loc1+ stockDetails[0].length()+1) + (Integer.parseInt(stockDetails[1]) - amount) + ownedStocks.substring(loc1+stock.length()));
                } else {
                    System.out.println("You don't own that many shares. ");
                    return;
                }
            }

        }
    }

    public void ownedStocks(){
        if (ownedStocks.equals("")){
            System.out.println("You don't have any stocks in your Account. ");
            return;
        }
        String[] ownList = ownedStocks.split(",");
        for (String stock: ownList){
            String[] stockDetails = stock.split(";");
            System.out.print(stockDetails[0]);
            System.out.print(" ");
            System.out.println(stockDetails[1]);
        }
    }

    public void walletAmount(){
        System.out.println(format1.format(wallet));
    }

    public int days(){
        return day;
    }

    public void nextDay(Stock[] market){
        for(Stock stock : market){
            stock.priceChange();
        }
        day++;
    }
}