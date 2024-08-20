package DIS.TraadOpgave.FletteViaTraade;

import java.util.List;

public class Traad2 extends Thread{
    private List<Integer> liste;
    private FletteSortering sortering;

    public Traad2(List<Integer> liste, FletteSortering sortering) {
        this.liste = liste;
        this.sortering = sortering;
    }

    @Override
    public void run() {
        sortering.mergesort(liste,liste.size()/2,liste.size());
    }
}

