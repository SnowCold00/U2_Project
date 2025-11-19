import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


    }

    public static String randomNames(){
        int length = (int) ((Math.random()*5) + 1);
        String word = "";
        for(int i = 0; i < length; i ++){
            word += (char) ('A' + ((int) ((Math.random()*27))));
        }
        return word;
    }
}