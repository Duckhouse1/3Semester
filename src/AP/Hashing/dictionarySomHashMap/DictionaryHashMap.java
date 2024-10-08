package AP.Hashing.dictionarySomHashMap;

import java.util.HashMap;
import java.util.Map;

public class DictionaryHashMap<K, V> implements Dictionary<K, V> {

    private Map<K, V>[] tabel;
    private static int N = 13;
    private int size = 0;
    /**
     * HashingMap constructor comment.
     */

    public DictionaryHashMap() {
        tabel = new HashMap[N];
        for (int i = 0; i < N; i++) {
            tabel[i] = new HashMap<K, V>();
        }
    }

    @Override
    public V get(K key) {
        V element = null;
        int bucketIndex = key.hashCode();
        if (tabel[bucketIndex].containsKey(key)){
            return tabel[bucketIndex].get(key);
        }
        return element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V put(K key, V value) {
        int hashCode = key.hashCode();
        if (tabel[hashCode].containsKey(key)){
            V oldValue = tabel[hashCode].get(key);
            tabel[hashCode].replace(key,value);
            return oldValue;
        } else {
            tabel[hashCode].put(key,value);
            size++;
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int hashCode = key.hashCode();
        if (tabel[hashCode].containsKey(key)){
            size--;
            return tabel[hashCode].remove(key);
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

}
