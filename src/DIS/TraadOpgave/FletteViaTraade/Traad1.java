package DIS.TraadOpgave.FletteViaTraade;

import java.util.List;

public class Traad1 extends Thread{
    private List<Integer> liste;
    private FletteSortering sortering;

    public Traad1(List<Integer> liste, FletteSortering sortering) {
        this.liste = liste;
        this.sortering = sortering;
    }

    @Override
    public void run() {
        sortering.mergesort(liste,0,liste.size()/2);
    }
}
