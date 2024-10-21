package AP.Hashing.afleveringstuderende;

public class DictionaryDoubleHashing<K, V> implements Dictionary<K, V> {
    private Entry<K, V>[] table;
    private int size;

    private final Entry DELETED = new Entry(null, null);

    public DictionaryDoubleHashing(int length) {
        table = new Entry[length];
        size = 0;
    }

    private int hash(int hashCode) {
        if (hashCode < 0) {
            hashCode = -hashCode;
        }
        return hashCode % table.length;
    }

    //Tidskompleksiteten ved denne metode er O(n) da i worst-case skal den løbe igennem hele tabellen én hel gang
    //Så det er O(n) hvor n repræsentere tabel længden
    @Override
    public V get(K key) {
        int hashCode = hash(key.hashCode());
        boolean found = false;
        int counter = 1;
        while (!found && counter <= table.length) {
            if (table[hashCode].key.equals(key)) {
                found = true;
                return table[hashCode].value;
            } else {
                int offSet = 7 - (key.hashCode() % 7);
                hashCode = hashCode + (counter * offSet);
                if (hashCode >= table.length) {
                    hashCode %= table.length;
                }
                counter++;
            }
        }
        return null;
    }
    //Denne metode har en konstant tidskompleksitet O(1) da der kun returneres en allerede kendt værdi.
    // Det tager en konstant tid uafhængigt af hashtabellens størrelse. Derfor er tidskompleksiteten O(1).
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //Tidskompleksiteten ved denne metode er O(n) da i worst-case skal den løbe igennem hele tabellen én hel gang
    //Så det er O(n) hvor n repræsentere tabel længden
    @Override
    public V put(K key, V value) {
        int hashCode = hash(key.hashCode());
        boolean availableSpot = false;
        Entry newEntry = new Entry<>(key, value);
        int offSetCounter = 1;
        while (!availableSpot && table[hashCode] != null && table[hashCode] != DELETED && offSetCounter < table.length) {
            if (table[hashCode].key.equals(key)) {
                V oldValue = table[hashCode].value;
                table[hashCode].value = value;
                return oldValue;
            }
            int offSet = 7 - (key.hashCode() % 7);
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

    //Tidskompleksiteten ved denne metode er O(n) da i worst-case skal den løbe igennem hele tabellen én hel gang.
    //Så det er O(n) hvor n repræsentere tabel længden
    @Override
    public V remove(K key) {
        int hashCode = hash(key.hashCode());
        boolean contains = true;
        while (table[hashCode].key != key && contains) {
            int offSet = 7 - (key.hashCode() % 7);
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

    //Tidskompleksiteten ved denne metode er O(n) da i worst-case skal den løbe igennem hele tabellen én hel gang
    public void rehash() {
        Entry<K, V>[] oldList = table;
        table = new Entry[(table.length * 2) + 1];
        size = 0;
        for (int i = 0; i < oldList.length; i++) {
            if (oldList[i] != null) {
                put(oldList[i].getKey(), oldList[i].getValue());
            }
        }
    }

    //Denne metode har en konstant tidskompleksitet O(1) da der kun returneres en allerede kendt værdi.
    // Det tager en konstant tid uafhængigt af hashtabellens størrelse. Derfor er tidskompleksiteten O(1).
    @Override
    public int size() {
        return size;
    }


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
