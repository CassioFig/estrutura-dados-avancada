public class Main {
    public static void main(String[] args) {
        AvlTree tree = new AvlTree(20);

        tree.insert(15);
        tree.insert(25);
        tree.insert(12);
        tree.insert(17);
        tree.insert(24);
        tree.insert(30);
        tree.insert(10);
        tree.insert(14);
        tree.insert(13);

        tree.print();

        System.out.println("-----------------------------------------");
        System.out.println("Árvore balanceada!");

//        tree.delete(4);

//        tree.print();
    }
}
