package AP.DesignPattern.Template.Sekvens_Flette;

import java.util.Iterator;

public interface Sequence<E> {
    // Objektet obj er adderet bagest i sekvensen
    public void add(E obj);

    // objekterne fra s er adderet bagest i
    // sekevensen, i samme rækkefølge som de er i s
    public void addAll(Sequence<E> s);

    // Krav: sekvensen er ikke tom
    // Returnerer det første objekt i sekvensen.
    // Sekvensen ændres ikke
    public E head();

    // Returnerer om sekvensen er tom
    public boolean isEmpty();

    // Returnerer en iterator over sekvensen
    public Iterator<E> iterator();

    // Krav: sekvensen er ikke tom
    // Det første objekt i sekvensen er fjernet fra
    // sekvensen
    public void tail();
}
