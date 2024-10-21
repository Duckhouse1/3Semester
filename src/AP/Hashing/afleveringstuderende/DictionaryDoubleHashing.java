package AP.Hashing.afleveringstuderende;

public class DictionaryDoubleHashing<K, V> implements Dictionary<K, V> {
    private Entry<K, V>[] table;
    private int size;

    private final Entry DELETED = new Entry(null, null);

    public DictionaryDoubleHashing(int length) {
        table = new Entry[length];
        size = 0;
    }


    @Override
    public V get(K key) {
        int hashCode = key.hashCode();
        boolean found = false;
        int counter = 0;
        while (!found && counter <= table.length) {
            if (table[hashCode].key.equals(key)) {
                found = true;
                return table[hashCode].value;
            } else {
                hashCode++;
                counter++;
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
        boolean availableSpot = false;
        Entry newEntry = new Entry<>(key, value);
        int offSetCounter = 1;
        while (!availableSpot && table[hashCode] != null && table[hashCode] != DELETED && offSetCounter < table.length) {
            int offSet = 7 - ((int) key % 7);
            hashCode += (offSetCounter * offSet);
            if (hashCode >= table.length) {
                hashCode %= table.length;
            }
            if (table[hashCode] == null || table[hashCode] == DELETED) {
                availableSpot = true;
            } else {
                offSetCounter++;
            }
        }
        if (table[hashCode] == null || table[hashCode] == DELETED) {
            table[hashCode] = newEntry;
            size++;
            if (((double) size / table.length) >= 0.5) {
                rehash();
            }
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int hashCode = key.hashCode();
        boolean contains = true;
        while (table[hashCode].key != key && contains) {
            int offSet = 7 - ((int) key % 7);
            for (int i = 1; i <= table.length; i++) {
                hashCode = hashCode + (i * offSet);
                if (hashCode >= table.length) {
                    hashCode %= table.length;
                }
                if (i == table.length - 1) {
                    contains = false;
                }
            }
        }
        if (contains) {
            V oldValue = table[hashCode].value;
            table[hashCode] = DELETED;
            size--;
            return oldValue;
        }
        return null;
    }

    public void rehash() {
        Entry<K, V>[] oldList = table;
        table = new Entry[(table.length * 2) + 1];
        size = 0;
        for (int i = 0; i < oldList.length; i++) {
            if (oldList[i] != null) {
                K entryKey = oldList[i].getKey();
                V entryValue = oldList[i].getValue();
                put(entryKey, entryValue);
            }
        }
    }


    @Override
    public int size() {
        return size;
    }


    // method only for test purpose
    public void writeOut() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + "\t" + table[i]);
        }
    }

    private class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public String toString() {
            return "(" + key + " , " + value + ")";
        }
    }
}
