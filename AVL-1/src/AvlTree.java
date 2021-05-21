public class AvlTree {
    Node<Integer> root;

    public AvlTree(int value) {
        this.root = new Node<>(value);
    }

    public void insert(int value) {
        this.root = this.recursiveInsert(this.root, value);
    }

    private Node<Integer> recursiveInsert(Node<Integer> node, int value) {
        if (node == null) {
            return new Node<>(value);
        }

        if (value < node.value) {
            node.left = this.recursiveInsert(node.left, value);

        } else if (value > node.value) {
            node.right = this.recursiveInsert(node.right, value);

        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        return this.rotate(node, value);
    }

    public int height(Node<Integer> node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public int getBalance(Node<Integer> node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    private Node<Integer> rotate(Node<Integer> node, int value) {
        int balance = getBalance(node);

        if (balance > 1 && value < node.left.value) {
            return rightRotate(node);
        }

        if (balance < -1 && value > node.right.value) {
            return leftRotate(node);
        }

        if (balance > 1 && value > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && value < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private Node<Integer> leftRotate(Node<Integer> node) {
        Node<Integer> right = node.right;
        Node<Integer> leftNodeFromRight = right.left;

        right.left = node;
        node.right = leftNodeFromRight;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        right.height = Math.max(height(right.left), height(right.right)) + 1;

        return right;
    }

    private Node<Integer> rightRotate(Node<Integer> node) {
        Node<Integer> left = node.left;
        Node<Integer> rightNodeFromLeft = left.right;

        left.right = node;
        node.left = rightNodeFromLeft;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        left.height = Math.max(height(left.left), height(left.right)) + 1;

        return left;
    }
    
    public void print() {
        BTreePrinter.printNode(this.root);
    }
}
