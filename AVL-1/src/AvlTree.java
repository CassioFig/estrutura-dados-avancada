public class AvlTree {
    Node<Integer> root;

    public AvlTree(int value) {
        this.root = new Node<Integer>(value);
    }

    public void insert(int value) {
        this.recursiveInsert(this.root, value);
    }

    private Node<Integer> recursiveInsert(Node<Integer> node, int value) {
        if (node == null) {
            return new Node<Integer>(value);
        }

        if (value < node.value) {
            node.left = this.recursiveInsert(node.left, value);

        } else if (value > node.value) {
            node.right = this.recursiveInsert(node.right, value);
        }

        return node;
    }
    
    public void print() {
        BTreePrinter.printNode(this.root);
    }
}
