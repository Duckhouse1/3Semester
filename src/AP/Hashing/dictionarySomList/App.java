package AP.Hashing.dictionarySomList;

import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        Bil bil1 = new Bil(3789122,"Ferari","niewn","rød");
        Bil bil2 = new Bil(6739127,"Volkswagen","polo","pink");
        Bil bil3 = new Bil(1245822,"Suzuki","ignis","grå");
        Bil bil4 = new Bil(3789122,"Ferari","niewn","rød");

        HashSet<Bil> bilHashSet = new HashSet<>();
        bilHashSet.add(bil1);
        bilHashSet.add(bil2);
        bilHashSet.add(bil3);
        bilHashSet.add(bil4);

        System.out.println(bilHashSet.size());
        System.out.println(bilHashSet);
    }
}
