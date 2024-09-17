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
		Node newNode = new Node(key,value);
        if (root == null) {
            root = newNode;
            return newNode.value;
        } else {
			Node current = root;
			if (current.key.compareTo(key) > 0){
				current = root.left;
				while (current.left != null || current.right != null) {
					while (current.key.compareTo(key) > 0) {
						current = current.left;
					}
					while (current.key.compareTo(key) < 0){
						current = current.right;
					}
				}
			} else if (current.key.compareTo(key) == 0) {
                Node gammelNode = current;
				current = newNode;
                return gammelNode.value;
			} else {
				current = root.right;
				while (current.left != null || current.right != null) {
					while (current.key.compareTo(key) > 0) {
						current = current.left;
					}
					while (current.key.compareTo(key) < 0){
						current = current.right;
					}
				}
			}
            if (current.key.compareTo(key) > 0){
				current.left = newNode;
			} else {
				current.right = newNode;
			}
        }
        return newNode.value;

    }

    @Override
    public V remove(K key) {
        // TODO
        return null;
    }

    @Override
    public int size() {
        // TODO
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
