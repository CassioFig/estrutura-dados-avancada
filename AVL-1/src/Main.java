public class Main {
    public static void main(String[] args) {
        AvlTree tree = new AvlTree(4);

        tree.insert(1);
        tree.insert(2);
        tree.insert(7);
        tree.insert(6);
        tree.insert(5);

        tree.print();

    }
}
