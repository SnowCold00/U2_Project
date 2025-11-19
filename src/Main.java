public class Main {
    public static void main(String[] args) {

        Stock Apple = new Stock("Apple" , 100);
        Account new1 = new Account("James");
        new1.buyStock(Apple,7);
        new1.ownedStocks();



    }
}