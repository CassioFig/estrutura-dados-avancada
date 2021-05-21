public class Main {
    public static void main(String[] args) {
        AvlTree tree = new AvlTree(2);

        tree.insert(1);
        tree.insert(4);
        tree.insert(5);
        tree.insert(3);
        tree.insert(6);
//        tree.insert(16);

        tree.print();
    }
}
