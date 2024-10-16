package AP.Hashing.dictionarySomList;

import java.util.LinkedList;
import java.util.List;

public class DictionaryList<K, V> implements Dictionary<K, V> {

    private List<Item>[] tabel;
    private static int N = 13;
    private int size = 0;

    /**
     * HashingMap constructor comment.
     */

    public DictionaryList() {
        tabel = new List[N];
        for (int i = 0; i < N; i++) {
            tabel[i] = new LinkedList<Item>();
        }
    }

    @Override
    public V get(K key) {
        int bucketIndex = key.hashCode();
        for (int i = 0; i < tabel[bucketIndex].size(); i++) {
            if (tabel[bucketIndex].get(i).getKey().equals(key)) {
                return tabel[bucketIndex].get(i).value;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V put(K key, V value) {
        int hashCode = key.hashCode();
        Item newItem = new Item(key, value);
        for (int i = 0; i < tabel[hashCode].size(); i++) {
            if (tabel[hashCode].get(i).key.equals(key)){
                V oldValue = tabel[hashCode].get(i).value;
                tabel[hashCode].set(i,newItem);
                return oldValue;
            }
        }
        tabel[hashCode].add(newItem);
        size++;
        return null;
    }


    @Override
    public V remove(K key) {
        int hashCode = key.hashCode();
            for (int i = 0; i < tabel[hashCode].size(); i++) {
                if (tabel[hashCode].get(i).key.equals(key)){
                    V oldValue = tabel[hashCode].get(i).value;
                    tabel[hashCode].remove(i);
                    size--;
                    return oldValue;
                }
            }
            return null;
        }


    @Override
    public int size() {
        return size;
    }

    private class Item {
        private K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
