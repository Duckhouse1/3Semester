package AP.Stream.exercises1;

import AP.Graph.grafalgoritmer.Edge;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercises1 {

    public static void main(String[] args) {
        // Liste med tal mellem 1 - 50
        List<Integer> list = List.of(1,2,3,2,1,6,3,4,5,2,3,8,8,9,34,32);
        list.stream().forEach(e-> System.out.println(e+1));

        //	Udskriver det største element i listen
        System.out.println(list.stream().max((e1,e2) -> e1.compareTo(e2)));

        //	Afgør og udskriver om alle tallene i listen er mindre end 50
        System.out.println(list.stream().allMatch(e -> e > 50));
        // 	Udskriver antallet af lige tal i listen
        System.out.println(list.stream().filter(e -> e%2 == 0).count());
        //	Udskriver antallet af ulige tal i listen
        System.out.println(list.stream().filter(e -> e%2 == 1).count());
        //  Udskriver
        //      Gennemsnittet af tallene i listen
        System.out.println(list.stream().mapToDouble(e -> e).average());
        //      Antallet af tallene i listen
        System.out.println(list.stream().count());
        //      Antallet af tallene i listen der er større end gennemsnittet
        System.out.println("UNder og over gennemsnit:");
        double average = list.stream().mapToDouble(e -> e).average().orElse(0.0); // Get the average value, defaulting to 0.0 if empty
        System.out.println("Over");
        System.out.println(list.stream().mapToDouble(e -> e).filter(e -> e > average).count());
        System.out.println("UNder");
        //      Antallet af tallene i listen der er mindre end gennemsnittet
        System.out.println(list.stream().mapToDouble(e -> e).filter(e -> e < average).count());
        //	    Udskriver antallet af gange de forskellige tal forekommer i listen
        System.out.println();
        //	    Udskriver antallet af gange de forskellige tal forekommer i listen i sorteret orden
    }
}
