import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    //Inorder Traversal
    //left - root - right
    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    //Post Order Traversal
    //left - right - root
    public static void PostOrder(Node root) {
        if (root == null) return;
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data + " ");
    }

    //Pre Order Traversal
    //root - left - right
    public static void PreOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        PreOrder(root.left);
        PreOrder(root.right);
    }

    //Level Order Traversal
    public static void levelOrder(Node root) {
        if(root == null) return;
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()){
            Node curr = Q.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null){
                Q.add(curr.left);
            }
            if (curr.right != null){
                Q.add(curr.right);
            }
        }
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
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
            // trả về root sau mỗi lần insert và cứ vậy update nó
        }
        scan.close();
        System.out.println("Level Order");
        levelOrder(root);

        System.out.println("\nInOrder Traversal");
        inOrder(root);

        System.out.println("\nPreOrder Traversal");
        PreOrder(root);

        System.out.println("\nPostOrder Traversal");
        PostOrder(root);
    }
}