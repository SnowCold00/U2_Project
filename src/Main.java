import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Please eneter your username: ");
        String name = input.nextLine();
        Account newAccount = new Account(name);
        Stock[] stockMarket = market();
        String userActionHolder;
        int amountOfStockHolder;
        String stockNameHolder;
        while (newAccount.days() < 10){
            System.out.println("Please type in a command ");
            System.out.println("buy = buy stock");
            System.out.println("sell = sell stock");
            System.out.println("owned stocks = check stocks owned");
            System.out.println("next day = move to the next day");
            System.out.println("check stocks = check stock market");
            userActionHolder = input.nextLine();
            if (userActionHolder.equals("buy")){
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

            } else if (userActionHolder.equals("sell")){
                for(Stock stock : stockMarket){
                    stock.info();
                }
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
            } else if (userActionHolder.equals("owned stocks")){
                newAccount.ownedStocks(stockMarket);

            } else if (userActionHolder.equals("next day")){
                newAccount.nextDay(stockMarket);

            } else if (userActionHolder.equals("check stocks")){
                for(Stock stock : stockMarket){
                    stock.info();
                }
            }
        }
        double total = newAccount.walletAmount() + newAccount.networth(stockMarket);
        System.out.println("total amount made = $" + total);
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
        int length = (int) ((Math.random()*5) + 1);
        String word = "";
        for(int i = 0; i < length; i ++){
            word += (char) ('A' + ((int) ((Math.random()*26))));
        }
        return word;
    }

}