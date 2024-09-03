package AP.BinærTree;

public class App {
    public static void main(String[] args) {
        BST træ = new BST<>();
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
//        træ.inorder();
//        træ.postorder();
//        træ.preorder();
        System.out.println(træ.inOrderList());
        System.out.println(træ.findmax());
    }
}
