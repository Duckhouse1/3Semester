package AP.DesignPattern.Template.SøgeSkabelon;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Integer> talListe = new ArrayList<>();

        talListe.add(34);
        talListe.add(2);
        talListe.add(23);
        talListe.add(1);
        talListe.add(55);

        SearchableList searchableList = new SearchableList<>(talListe);

        System.out.println(searchableList.search(22));

        List<String> stringList = new ArrayList<>();
        stringList.add("holme");
        stringList.add("Skåde");
        stringList.add("Viby");
        stringList.add("Beder");
        stringList.add("Stautrup");
        stringList.add("Engdal");
        stringList.add("Forældreskolen");
        stringList.add("Malling");

        SearchableList searchableListString = new SearchableList<>(stringList);

       System.out.println("Lineær: Malling - "+searchableListString.search("Malling"));
       System.out.println("Lineær: Riiskov - " +searchableListString.search("Riiskov"));

        SearchableBinærList searchableBinærList = new SearchableBinærList<>(stringList);

        System.out.println("Binær: Malling -  "+searchableBinærList.search("Malling"));
    }
}
