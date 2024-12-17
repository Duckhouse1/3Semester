package AP.DesignPattern.Template.SøgeSkabelon;

import java.util.List;

public class SearchableBinærList<E extends Comparable<E>> extends SearchPattern<E> {
    private List<E> list;
    private int leftIndex;
    private int rightIndex;
    private int midIndex;

    public SearchableBinærList(List<E> list) {
        this.list = list;
    }

    @Override
    protected void init() {
        leftIndex = 0;
        rightIndex = list.size() - 1;
        midIndex = leftIndex + (rightIndex - leftIndex) / 2;
    }

    @Override
    protected boolean isEmpty() {
        return leftIndex > rightIndex;
    }

    @Override
    protected E select() {
        midIndex = leftIndex + (rightIndex - leftIndex) / 2;
        return list.get(midIndex);
    }

    @Override
    protected void split(E m) {
        if (list.get(midIndex).compareTo(m) < 0) {
            leftIndex = midIndex + 1;
        } else {
            rightIndex = midIndex -1;
        }
    }
}
