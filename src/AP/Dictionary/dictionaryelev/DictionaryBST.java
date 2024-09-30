package AP.Dictionary.dictionaryelev;

public class DictionaryBST<K extends Comparable<K>, V> implements Dictionary<K, V> {

    private Node root;

    public DictionaryBST() {
        root = null;
    }

    @Override
    public V get(K key) {
        Node element = find(key);
        return element.value;


    }

    private Node find(K key) {
        Node current = root;
        boolean found = false;
        while (!found && current != null) {
            int d = current.key.compareTo(key);
            if (d == 0) {
                found = true;
            } else if (d > 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (found) {
            return current;
        } else {
            return null;
        }

    }

    @Override
    public boolean isEmpty() {
        // TODO
        return root == null;
    }

    @Override
    public V put(K key, V value) {
        Node newNode = new Node(key, value);
        if (root == null) {
            root = newNode;
            return null;
        }
        Node current = root;
        while (current != null) {
            int compareValue = key.compareTo(current.key);
            if (compareValue == 0) {
                V oldValue = current.value;
                current.value = value;
                return oldValue;
            } else if (compareValue < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        current = newNode;
        return null;
    }

    @Override
    public V remove(K key) {
        // TODO

        return null;
    }
    @Override
    public int size() {
//        // TODO
//        if (isEmpty()) {
//            return 0;
//        } else {
//            int counter = 1;
//            Node current;
//
//            return
//        }
        return -1;
    }

    private class Node {
        private K key;
        private V value;
        private Node left;
        private Node right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }


    }

}
