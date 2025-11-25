import java.text.DecimalFormat;
import java.util.Scanner;
//duplicate stock names
public class Main {
    public static void main(String[] args) {
        String[] previousNames = new String[100];
        Scanner input = new Scanner(System.in);
        DecimalFormat format1 = new DecimalFormat("$###,###,##0.00");

        System.out.print("Please eneter your username: ");
        String name = input.nextLine();
        Account newAccount = new Account(name);
        Stock[] stockMarket = market();
        String userActionHolder;
        int amountOfStockHolder;
        String stockNameHolder;
        while (newAccount.days() < 10){
            System.out.println();
            System.out.println("Day: " + newAccount.days());
            System.out.println("Cash: " + format1.format(newAccount.walletAmount()));
            System.out.println("Please type in a command ");
            System.out.println("buy = buy stock");
            System.out.println("sell = sell stock");
            System.out.println("owned = check stocks owned");
            System.out.println("next = move to the next day");
            System.out.println("check = check stock market");
            userActionHolder = input.nextLine().toLowerCase();
            if (userActionHolder.equals("buy") || userActionHolder.equals("buy ")){
                for(Stock stock : stockMarket){
                    stock.info();
                }
                System.out.println("Type in stock you would like to buy. ");
                stockNameHolder = input.nextLine();
                System.out.println("How many would you like to buy? ");
                amountOfStockHolder = input.nextInt();
                input.nextLine();
                for(Stock stock : stockMarket){
                    if (stock.nameStock().equals(stockNameHolder)){
                        newAccount.buyStock(stock,amountOfStockHolder);
                    }
                }

            } else if (userActionHolder.equals("sell") || userActionHolder.equals("sell ")){
                newAccount.ownedStocks(stockMarket);
                System.out.println("Type in stock you would like to sell. ");
                stockNameHolder = input.nextLine();
                System.out.println("How many would you like to sell? ");
                amountOfStockHolder = input.nextInt();
                input.nextLine();
                for(Stock stock : stockMarket){
                    if (stock.nameStock().equals(stockNameHolder)){
                        newAccount.sellStock(stock,amountOfStockHolder);
                    }
                }
            } else if (userActionHolder.equals("owned") || userActionHolder.equals("owned ")){
                newAccount.ownedStocks(stockMarket);

            } else if (userActionHolder.equals("next") || userActionHolder.equals("next ")){
                newAccount.nextDay(stockMarket);

            } else if (userActionHolder.equals("check") || userActionHolder.equals("check ")){
                for(Stock stock : stockMarket){
                    stock.info();
                }
            }
        }
        double total = newAccount.walletAmount() + newAccount.networth(stockMarket);
        System.out.println("total amount made = " + format1.format(total));
        input.close();

    }

    private static Stock[] market(){
        Stock[] stocks = new Stock[100];
        for(int i = 0; i <100; i++){
            Stock stock = new Stock(randomNames(),i);
            stocks[i] = stock;
        }
        return stocks;
    }

    private static String randomNames(){
            int length = (int) ((Math.random() * 5) + 1);
            String word = "";
            while (true) {
                for (int i = 0; i < length; i++) {
                    word += (char) ('A' + ((int) ((Math.random() * 26))));
                }
                break;
            }
            return word;
    }

}