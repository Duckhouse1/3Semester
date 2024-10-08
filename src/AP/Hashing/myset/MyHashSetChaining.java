package AP.Hashing.myset;

import java.text.Format;

public class MyHashSetChaining<E> implements MySet<E> {
    // The number of elements in the set
    private int size = 0;

    // Hash table is an array with each cell that is a linked list
    private Node<E>[] table;

    public MyHashSetChaining(int bucketsLength) {
        table = (Node<E>[]) new Node[bucketsLength];
        size = 0;
    }

    /**
     * Hash function
     */
    private int hash(int hashCode) {
        if (hashCode < 0) {
            hashCode = -hashCode;
        }
        return hashCode % table.length;
    }

    @Override
    /** Remove all elements from this set */
    public void clear() {
        Node<E>[] clearTable = new Node[table.length];
        size = 0;
        table = clearTable;
    }

    @Override
    /** Return true if the element is in the set */
    public boolean contains(E e) {
        int bucketIndex = hash(e.hashCode());
        Node<E> current = table[bucketIndex];
        boolean found = false;
        while (!found && current != null) {
            if (current.data.equals(e)) {
                found = true;
            } else {
                current = current.next;
            }
        }
        return found;
    }

    @Override
    /** Add an element to the set */
    public boolean add(E e) {
        int bucketIndex = hash(e.hashCode());
        Node<E> current = table[bucketIndex];
        boolean found = false;
        while (!found && current != null) {
            if (current.data.equals(e)) {
                found = true;
                // Already in the set
            } else {
                current = current.next;
            }
        }
        if (!found) {
            Node newNode = new Node();
            newNode.data = e;
            newNode.next = table[bucketIndex];
            table[bucketIndex] = newNode;
            size++;
            reHash();
        }
        return !found;
    }

    @Override
    /** Remove the element from the set */
    public boolean remove(E e) {
        int bucketindex = hash(e.hashCode());
        Node<E> current = table[bucketindex];
        Node<E> prev = null;
        boolean found = false;
        if (!contains(e)) {
            return false;
        } else {
            while (!found && current != null) {
                if (current.data.equals(e)) {
                    found = true;
                } else {
                    prev = current;
                    current = current.next;
                }
            }
            if (found) {
                if (prev != null) {
                    prev.next = current.next;
                    current = null;

                } else {
                    table[bucketindex] = current.next;
                    current = null;

                }
                size--;
            }
        }
        return found;
    }

    public void reHash() {
        if (((double) size / table.length) > 0.75) {
            Node<E>[] oldList = table;
            table = new Node[oldList.length * 2];
            for (int i = 0; i < oldList.length; i++) {
                Node<E> node = oldList[i];
                while (node != null) {
                    add(node.data);
                    node = node.next;
                }
            }
        }
    }

    @Override
    /** Return true if the set contains no elements */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    /** Return the number of elements in the set */
    public int size() {
        return size;
    }

    // method only for test purpose
    void writeOut() {
        for (int i = 0; i < table.length; i++) {
            Node<E> temp = table[i];
            if (temp != null) {
                System.out.print(i + "\t");
                while (temp != null) {
                    System.out.print(temp.data + "\t");
                    temp = temp.next;
                }
                System.out.println();
            }
        }
    }

    void writeAllOut() {
        for (int i = 0; i < table.length; i++) {
            Node<E> temp = table[i];
            // Print the index
            System.out.print(i + "\t");

            // If the bucket is not empty, print its elements
            if (temp != null) {
                while (temp != null) {
                    System.out.print(temp.data + "\t");
                    temp = temp.next;
                }
            } else {
                // If the bucket is empty, print "null"
                System.out.print("null");
            }

            // Move to the next line after printing the bucket
            System.out.println();
        }
    }

    public int getTableLength() {
        return table.length;
    }

    private class Node<E> {
        public E data;
        public Node<E> next;
    }

}
