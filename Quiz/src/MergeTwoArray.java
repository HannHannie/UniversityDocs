import java.io.*;
import java.util.*;

public class MergeTwoArray {

    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static Node mergeLists(Node a, Node b) {
        Node dummy = new Node(0), tail = dummy;
        while (a != null && b != null) {
            if (a.data < b.data) { tail.next = a; a = a.next; }
            else { tail.next = b; b = b.next; }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
        return dummy.next;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int tests = sc.nextInt();
        while (tests-- > 0) {
            Node list1 = null, list2 = null, tail = null;
            for (int i = sc.nextInt(); i > 0; i--) {
                Node n = new Node(sc.nextInt());
                if (list1 == null) list1 = tail = n; else { tail.next = n; tail = n; }
            }
            tail = null;
            for (int i = sc.nextInt(); i > 0; i--) {
                Node n = new Node(sc.nextInt());
                if (list2 == null) list2 = tail = n; else { tail.next = n; tail = n; }
            }
            Node merged = mergeLists(list1, list2);
            while (merged != null) { bw.write(merged.data + " "); merged = merged.next; }
            bw.newLine();
        }
        bw.close();
        sc.close();
    }
}