package homework4;

public class RedBlackTree {
    Node root;


    void add(int value) {
        Node node = new Node(value);
        Node current = root;
        while (true) {
            if (current == null) {
                current = node;
                break;
            } else if (value > current.value) {
                node.parent = current;
                current = current.right;
            } else {
                node.parent = current;
                current = current.left;
            }
        }
        rebalance(node.parent);
    }

    private void rebalance(Node node) {
        if (node == root && node.redColor) {
            node.changeColor();
            return;
        }
        if (node.right != null && node.right.redColor) {
            node.right.changeColor();
            if (node.left != null && node.left.redColor) {
                node.left.changeColor();
            }
            node.changeColor();
            rebalance(node);
            return;
        }
        if (node.redColor) {
            if ((node.left != null && node.left.redColor) ||
                    (node.right != null && node.right.redColor)) {
                rightTurn(node.parent);
                rebalance(node);
            }
        }
    }

    private void rightTurn(Node node) {
        Node parent = node.left;
        node.left = parent.right;
        node.left.parent = node;
        parent.right = node;
        parent.parent = node.parent;
        if (node != root) {
            if (node.parent.left == node) {
                node.parent.left = parent;
            } else {
                node.parent.right = parent;
            }
        } else {
            root = parent;
        }
        node.parent = parent;
    }

    private void leftTurn(Node node) {
        Node parent = node.right;
        node.right = parent.left;
        node.right.parent = node;
        parent.left = node;
        parent.parent = node.parent;
        if (node != root) {
            if (node.parent.left == node) {
                node.parent.left = parent;
            } else {
                node.parent.right = parent;
            }
        } else {
            root = parent;
        }
        node.parent = parent;
    }

    public boolean find(int value) {
        Node current = root;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            if (current.value < value) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return false;
    }

    class Node {
        int value;
        boolean redColor = true;

        Node left;
        Node right;
        Node parent;

        boolean color;

        public Node(int value) {
            this.value = value;
        }

        public void changeColor() {
            redColor = !redColor;
        }
    }
}
