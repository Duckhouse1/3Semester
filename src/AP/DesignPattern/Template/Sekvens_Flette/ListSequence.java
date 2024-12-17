package AP.DesignPattern.Template.Sekvens_Flette;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListSequence<E> implements Sequence<E>{
    private List<E> list;

    public ListSequence(){
        this.list = new ArrayList<>();
    }
    @Override
    public void add(E obj) {
        list.add(obj);
    }

    @Override
    public void addAll(Sequence<E> s) {
        while (s.iterator().hasNext()){
            E element = s.iterator().next();
            list.add(element);
        }
    }

    @Override
    public E head() {
        if (!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return list.size() == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public void tail() {
        if (!list.isEmpty()){
            list.remove(0);
        } else {
            throw new RuntimeException("Sekvenses er tom");
        }
    }
}
