import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

class GfG {
    static Node reverseList(Node head) {
        Node curr = head, prev = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}

public class ReverseLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            if (n == 0) {
                System.out.println();
                continue;
            }

            Node head = new Node(scanner.nextInt());
            Node temp = head;

            for (int i = 1; i < n; i++) {
                temp.next = new Node(scanner.nextInt());
                temp = temp.next;
            }

            head = GfG.reverseList(head);
            GfG.printList(head);
        }

        scanner.close();
    }
}
