package AP.DesignPattern.Template.SøgeSkabelon;

import java.util.List;

public class SearchableList<E extends Comparable<E>> extends SearchPattern<E> {
    private List<E> list;
    private int currentIndex;

    public SearchableList(List<E> list){
        this.list = list;
    }

    @Override
    protected void init() {
        currentIndex = 0;
    }

    @Override
    protected boolean isEmpty() {
        return currentIndex > list.size()-1;
    }

    @Override
    protected E select() {
        return list.get(currentIndex);
    }

    @Override
    protected void split(E m) {
            currentIndex++;
        }


}
