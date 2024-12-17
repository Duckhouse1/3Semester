package AP.DesignPattern.Template.Sekvens_Flette;

public abstract class MergeTemplate<E extends Comparable<E>>{
    protected Sequence<E> g;
    // Template method med fletteskabelonen
    // Pre: s1 og s2 er sorteret i ikke aftagende orden
    // g er en tom sekvens
    // Post: g sorteret sekvens indeholdende resultatet af
    // fletningen af s1 og s2
    public final Sequence<E> merge(Sequence<E> s1, Sequence<E> s2,
                                   Sequence<E> g) {
        this.g = g;
        while (!s1.isEmpty() && !s2.isEmpty()){
            if ( (s1.head()).compareTo(s2.head()) < 0 ) {
                move1(s1);
            }
            else if( s1.head().compareTo(s2.head()) > 0 ) {
                move2(s2);
            }
            else {
                move3(s1,s2);
            }
        }
        if (!s1.isEmpty()){
            moveTail1(s1);
        }
        else if (!s2.isEmpty()){
            movetail2(s2);
        }
        return g;
    }
    // Primitive metoder der kaldes fra Template Method og
// overskrives i subklasser
    protected void move1(Sequence<E> s){}
    protected void move2(Sequence<E> s){}
    protected void move3(Sequence<E> s1, Sequence<E> s2){}
    protected void moveTail1(Sequence<E> s){}
    protected void movetail2(Sequence<E> s){}
}
