public class Node<T extends Comparable<?>> {
    Node<T> left, right;
    T value;
    int height;

    public Node(T value) {
        this.value = value;
        this.height = 1;
    }
}
