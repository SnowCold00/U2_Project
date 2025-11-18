public class Main {
    public static void main(String[] args) {

        Stock Apple = new Stock("Apple" , 100);
        for(int i = 1; i < 100; i ++) {
            Apple.priceChange();
            Apple.info();
        }

    }
}