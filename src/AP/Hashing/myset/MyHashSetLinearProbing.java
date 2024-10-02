package AP.Hashing.myset;

/**
 * This class implements a hash set using separate chaining.
 */
public class MyHashSetLinearProbing<E> implements MySet<E> {
    private E[] table;
    private int size;

    private final E DELETED = (E) new Object();

    /**
     * Constructs a hash table.
     *
     * @param bucketsLength the length of the buckets array
     */
    public MyHashSetLinearProbing(int bucketsLength) {
        table = (E[]) new Object[bucketsLength];
        size = 0;
    }

    private int hash(int hashCode) {
        if (hashCode < 0) {
            hashCode = -hashCode;
        }
        return hashCode % table.length;
    }

    @Override
    /** Return true if the element is in the set */
    public boolean contains(E e) {
        int bucketindex = hash(e.hashCode());
        boolean found = false;
        int counter = 0;
        while (!found &&  counter <= table.length-1){
            if (table[bucketindex] == e){
                found = true;
            } else if (bucketindex == table.length-1) {
                bucketindex = 0;
                counter++;
            } else {
                bucketindex++;
                counter++;
            }
        }
        return table[bucketindex] == e;
    }

    @Override
    /** Remove all elements from this set */
    public void clear() {
        E[] newList = (E[]) new Object[table.length];
        table = newList;
    }

    /**
     * Add an element to the set.
     *
     * @return true if e is a new object, false if e was already in the set
     */
    public boolean add(E e) {
        int bucketIndex = hash(e.hashCode());
        boolean availableIndex = false;
        if (table[bucketIndex] == null || table[bucketIndex] == DELETED) {
            availableIndex = true;
            E newObject = e;
            table[bucketIndex] = newObject;
            size++;
            return availableIndex;
        } else {
            while (table[bucketIndex] != null && !availableIndex) {
                if (table[bucketIndex] == DELETED) {
                    availableIndex = true;
                } else if (bucketIndex == table.length - 1) {
                    bucketIndex = 0;
                } else {
                    bucketIndex++;
                }
            }
            E newObject = e;
            table[bucketIndex] = newObject;
            size++;
            return availableIndex;
        }
}

    /**
     * Remove the element from the set.
     *
     * @return true if e was removed from this set, false if e was not an
     * element of this set
     */
    public boolean remove(E e) {
        // TODO
        return false;
    }

    @Override
    /** Return the number of elements in the set */
    public int size() {
        return size;
    }

    @Override
    /** Return true if the set contains no elements */
    public boolean isEmpty() {
        return size == 0;
    }


    // method only for test purpose
    public void writeOut() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + "\t" + table[i]);
        }
    }


}
