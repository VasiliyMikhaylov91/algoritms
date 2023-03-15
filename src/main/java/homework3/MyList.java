package homework3;

public class MyList {
    Node Head;

    void add(int value) {
        if (Head == null) {
            Head = new Node(value);
            return;
        }
        Node current = Head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(value);
    }

    void print() {
        if (Head == null) return;
        Node current = Head;
        do {
            System.out.printf("%d ", current.value);
            current = current.next;
        } while (current != null);
        System.out.println();
    }

    void revert() {
        if (Head == null || Head.next == null) return;
        revert(Head, null);
    }

    private void revert(Node current, Node previous) {
        if (current == null) {
            Head = previous;
            return;
        }
        revert(current.next, current);
        current.next = previous;
    }

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
