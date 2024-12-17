package AP.DesignPattern.Template.Sekvens_Flette;

public class FindAll<E extends Comparable<E>> extends MergeTemplate<E>{
    @Override
    protected void move1(Sequence<E> s) {
        g.add(s.head());
        s.tail();
    }

    @Override
    protected void moveTail1(Sequence<E> s) {
       // g.add();
    }
}
