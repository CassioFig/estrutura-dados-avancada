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
        return this.rotateAfterInsert(node, value);
    }

    public void delete(int value) {
        this.root = this.deleteRecursive(this.root, value);
    }

    private Node<Integer> deleteRecursive(Node<Integer> node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            node.left = deleteRecursive(node.left, value);

        } else if (value > node.value) {
            node.right = deleteRecursive(node.right, value);

        } else {
            if (node.left == null || node.right == null) {

                Node<Integer> aux = null;
                if (aux == node.left) {
                    aux = node.right;

                } else {
                    aux = node.left;
                }

                if (aux == null) {
                    aux = node;
                    node = null;

                } else {
                    node = aux;
                }

            } else {
                Node<Integer> aux = minValue(node.right);

                node.value = aux.value;
                node.right = deleteRecursive(node.right, aux.value);
            }
        }

        if (node == null) {
            return null;
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return rotateAfterDelete(node);
    }

    private Node<Integer> minValue(Node<Integer> node) {
        Node<Integer> current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public int height(Node<Integer> node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private Node<Integer> rotateAfterDelete(Node<Integer> node) {
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }

        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && getBalance(node.right) <= 0 ) {
            return leftRotate(node);
        }

        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private Node<Integer> rotateAfterInsert(Node<Integer> node, int value) {
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

    public int getBalance(Node<Integer> node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
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
