import java.util.*;
public class Tree {
    class Node{
        Node left;
        Node right;
        int data;
        //constructor
        public Node(int data){
            left = null;
            right = null;
            this.data = data;
        }
    }
    private Node root;
    private int comparisons;
    public Tree(){
        root = null;
        comparisons = 0;
    }

    //Problem 01:
    private int countNode(Node root){
        if (root == null) return 0;
        else
            return 1 + countNode(root.left) + countNode(root.right);
    }
    public int countElements(){
        return countNode(root);
    }

    //Problem 02:
    private int heightRecursion(Node root){
        if (root == null) return -1;

        int leftHeight = heightRecursion(root.left);
        int rightHeight = heightRecursion(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
    public int HeightofTree(){
        return heightRecursion(root);
    }

    //Problem 02(2):
    private int countLeaveNode(Node root){
        if (root == null) return 0;
        else if (root.left == null && root.right == null)
            return 1;
        else
            return countLeaveNode(root.left) + countLeaveNode(root.right);
    }
    public int countLeave(){
        return countLeaveNode(root);
    }

    //Problem 03:
    private boolean isBalanced(Node root){
        if (root == null) return true;
        int leftHeight = heightRecursion(root.left);
        int rightHeight = heightRecursion(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public boolean balanced(){
        return isBalanced(root);
    }

    //Problem 04:
    private boolean isIdentical(Node root1, Node root2){
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.data != root2.data) return false;
        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }
    public boolean identical(Node anotherRoot){
        return isIdentical(root, anotherRoot);
    }

//=====================================================================================
    //Problem TreeApp
    public Node find(Node root, int val){
        comparisons ++;
        if (root == null || root.data == val)
            return root;
        if (val < root.data){
            comparisons ++;
            return find(root.left, val);
        } else {
            comparisons ++;
            return find(root.right, val);
        }
    }

    public Node insert(Node root, int val){
        comparisons ++;
        if (root == null) return new Node(val);
        if (val < root.data){
            comparisons ++;
            root.left = insert(root.left, val);
        } else if (val > root.data){
            comparisons ++;
            root.right = insert(root.right, val);
        }
        return root;
    }

    public Node delete(Node root, int val){
        if (root == null) return root;
        while(root.data != val){
            comparisons ++;
            if ( val < root.data){
                comparisons ++;
                delete(root.left, val);
            } else if (val > root.data){
                comparisons ++;
                delete(root.right, val);
            } else {
                comparisons ++;
                if (root.left == null && root.right == null){
                    return null;
                } else if (root.left == null){
                    return root.right;
                } else if (root.right == null){
                    return root.left;
                }
                root.data = minValue(root.right);
                root.right = delete(root.right, root.data);
            }
        }
        return root;
    }

    public void clear() {
        root = null;
        System.out.println("Tree has been cleared");
    }

    public void insertRandomItems(int numItems, int minValue, int maxValue) {
        Random rand = new Random();
        for (int i = 0; i < numItems; i++) {
            int randomValue = rand.nextInt((maxValue - minValue) + 1) + minValue;
            System.out.println("Inserting: " + randomValue);
            root = insert(root, randomValue);
        }
    }

    public int minValue(Node root){
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public int maxValue(Node root){
        int maxValue = root.data;
        while (root.right != null) {
            maxValue = root.right.data;
            root = root.right;
        }
        return maxValue;
    }

    public void saveItems(Node root, List<Integer> list){
        if(root == null) return;

        saveItems(root.left, list);
        list.add(root.data);
        saveItems(root.right, list);
    }

    public void reInsertTree(Node root, List<Integer> list){
        clear();
        for (int val : list){
            insert(root, val);
        }
    }
}
