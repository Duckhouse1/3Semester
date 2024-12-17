package AP.DesignPattern.Template.Sekvens_Flette;

import java.util.Iterator;

public class App {
    public static void main(String[] args) {
        ListSequence AGF = new ListSequence<>();

        Team basketTirsdag = new Team("Basketball", Weekday.TIRSDAG);
        Team volleyTirsdag = new Team("Volley", Weekday.TIRSDAG);
        Team fodboldTorsdag = new Team("Fodbold", Weekday.TORSDAG);
        Team håndboldTorsdag = new Team("Håndbold", Weekday.TORSDAG);

        AGF.add(basketTirsdag);
        AGF.add(volleyTirsdag);
        AGF.add(fodboldTorsdag);
        AGF.add(håndboldTorsdag);

        ListSequence AIA = new ListSequence<>();

        Team basketballTirdag = new Team("Basket", Weekday.TIRSDAG);
        Team floorBallOnsdag = new Team("Floorball", Weekday.ONSDAG);
        Team bold = new Team("Bold", Weekday.TORSDAG);

        AIA.add(basketballTirdag);
        AIA.add(floorBallOnsdag);
        AIA.add(bold);

        Iterator iterator = AGF.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Iterator AIAITerator = AIA.iterator();
        while (AIAITerator.hasNext()){
            System.out.println(AIAITerator.next());
        }
    }
}
