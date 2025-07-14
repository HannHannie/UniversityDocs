class Node{
    long data;
    Node next;
    //constructor
    Node(long data){
        this.data = data;
        this.next = null;
    }
}

class Link{
    private Node head;

    public Link(){
        head = null;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addfirst(long data){
        Node insert = new Node(data);
        insert.next = head; //gán node mới ở đầu list
        head = insert; //update để con trỏ đầu list tới node mới
    }

    public long deletefirst(){
        Node curr = head;
        head = head.next;
        return curr.data;
    }

    public void displayList(){
        Node curr = head;
        while (curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
class LinkStack{
    private Link ll;
    public LinkStack(){
        ll = new Link();
    }

    public void push(long j){
        ll.addfirst(j);
    }

    public long pop(){
        return ll.deletefirst();
    }

    public void displayStack(){
        ll.displayList();
    }
}

public class LinkStackApp{
    public static void main(String[] args) {
        LinkStack ls = new LinkStack();

        ls.push(10);
        ls.push(20);
        ls.push(30);
        ls.push(40);
        ls.pop();
        ls.displayStack();
    }
}