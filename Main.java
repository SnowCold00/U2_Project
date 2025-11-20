import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Stock randomNames() = new Stock(randomNames());
        Stock stock = new Stock(randomNames());
        Account Jimmy = new Account("Jimmy");

        Jimmy.buyStock(new1,5);


    }

    private static String randomNames(){
        int length = (int) ((Math.random()*5) + 1);
        String word = "";
        for(int i = 0; i < length; i ++){
            word += (char) ('A' + ((int) ((Math.random()*27))));
        }
        return word;
    }

}