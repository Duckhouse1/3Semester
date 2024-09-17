package AP.BinærTree;

public class App {
    public static void main(String[] args) {
        BST<Integer> træ = new BST<>();
        træ.insert(45);
        træ.insert(22);
        træ.insert(11);
        træ.insert(15);
        træ.insert(30);
        træ.insert(25);
        træ.insert(77);
        træ.insert(90);
        træ.insert(88);

        System.out.println(træ);
//        System.out.println("Inorder:");træ.inorder();
//        System.out.println("postOrder:");træ.postorder();
//        System.out.println("preorder:");træ.preorder();
//        System.out.println(træ.inOrderList());
//        System.out.println(træ.findMax());
//        System.out.println(træ.findMin());
        System.out.println(træ.leafCount(træ.getRoot()));
        System.out.println("Det mindste element var " + træ.removeMin() + " og det er fjernet:");
        System.out.println(træ);
        System.out.println("Det største element var " + træ.removeMax() + " og det er fjernet:");
        System.out.println(træ);
        System.out.println(træ.greaterThanCount(4));

    }
}
