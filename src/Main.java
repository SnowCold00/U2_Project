import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Stock Stock1 = new Stock(randomNames(),1);
        Stock Stock2 = new Stock(randomNames(),2);
        Account Jimmy = new Account("Jimmy");

        Jimmy.buyStock(Stock1,5);
        Jimmy.buyStock(Stock2,5);
        Jimmy.buyStock(Stock1,3);
        Jimmy.walletAmount();
        Jimmy.ownedStocks();
        Jimmy.sellStock(Stock1,4);
        Jimmy.walletAmount();
        Jimmy.ownedStocks(); //buying selling done work on not making the user broke lol


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