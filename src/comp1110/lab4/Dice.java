package comp1110.lab4;

import java.util.Random;

public class Dice {
    public static void main(String[] args) {
        for (int i = 0;i<10;i++){
            Random d = new Random();
            System.out.println(d.nextInt(6)+10);
        }
    }

}
