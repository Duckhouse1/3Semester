package DIS.TraadOpgave.FletteViaTraade;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestFlettesortering {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Random r = new Random();

        for (int i = 0; i < 25; i++) {
            list.add(Math.abs(r.nextInt() % 10000));
        }
        System.out.println(list);
        FletteSortering sort = new FletteSortering();

        long l1, l2;
        l1 = System.nanoTime();
        Traad1 traad1 = new Traad1(list,sort);
        Traad2 traad2 = new Traad2(list,sort);
        traad1.start();
        traad2.start();
        l2 = System.nanoTime();
        System.out.println();
        System.out.println("Koeretiden var " + (l2 - l1) / 1000000);
        System.out.println();
        System.out.println(list);
    }
}

