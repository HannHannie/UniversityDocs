class LinkedList{
    private Node head;

    class Node{
        int data;
        Node next;
        //constructor
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void add(int data){
        Node insert = new Node(data);
        if (head == null){
            head = insert;
            return;
        }

        Node current = head;
        while (current.next != null){
            current = current.next; //find out the last node
        }
        current.next = insert;
    }

    //take the first element
    public Integer getFirst(){
        if (head != null){
            return head.data;
        } else {
            return null;
        }
    }

    //take the last element
    public Integer getLast(){
        if (head == null){
            return null;
        }
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        return current.data;
    }

    //toString
    @Override
    public String toString(){
        if (head == null){
            return "[]";
        }
        StringBuilder str = new StringBuilder();
        str.append("[");

        Node current = head;
        while (current != null){
            str.append(current.data);
            if (current.next != null){
                str.append(", ");
            }

            current = current.next;
        }
        str.append("]");
        return str.toString();
    }
}

public class LinkListApp{
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        System.out.println(ll);
        System.out.println("First element: " + ll.getFirst());
        System.out.println("Last element: " + ll.getLast());
    }
}