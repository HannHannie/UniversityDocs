import java.io.*;
import java.util.*;

class Node{
    Node left, right;
    int data;
    //constructor
    public Node(int data){
        left = null;
        right = null;
        this.data = data;
    }
}

public class Tree15 {
    public static void PostOrder(Node root) {
        if (root == null) return;
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> values = new ArrayList<>();
        int prev = Integer.MIN_VALUE;

        while (sc.hasNextInt()) {
            int curr = sc.nextInt();
            if (prev == -1 && curr == -1) break;
            values.add(curr);
            prev = curr;
        }

        Node root = null;
        for (int val : values){
            if (val != -1)
                root = insert(root, val);
        }
        PostOrder(root);
    }
}