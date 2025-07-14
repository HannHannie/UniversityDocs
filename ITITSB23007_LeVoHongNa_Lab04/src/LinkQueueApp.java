class NodeQ{
    long data;
    NodeQ next;
    //constructor
    NodeQ(long data){
        this.data = data;
        this.next = null;
    }
}
class LinkQ{
    private NodeQ head;
    private NodeQ tail;
    private int size;

    public LinkQ(){ //constructor
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void insertLast(long data){
        NodeQ newNode = new NodeQ(data);
        if (head == null){
            head = newNode;
        } else {
            tail.next = newNode; //gán newNode vào cuối tail
        }
        tail = newNode; //trỏ tail tới newNode
        size ++;
    }

    public long deleteFirst(){
        NodeQ curr = head;
        if (head == null){
            tail = null; //list rỗng
        }
        head = head.next; //ignore head đầu
        size --;
        return curr.data;
    }

    public int size(){
        return size;
    }

    public void displayList(){
        NodeQ curr = head;
        while (curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

class LinkQueue{
    private LinkQ lq;
    public LinkQueue(){ //constructor
        this.lq = new LinkQ();
    }

    public void offer(long newdata){
        lq.insertLast(newdata);
    }

    public long poll(){
        return lq.deleteFirst();
    }

    public int size(){
        return lq.size();
    }

    public void displayQueue(){
        lq.displayList();
    }
}

public class LinkQueueApp{
    public static void main(String[] args) {
        LinkQueue lqa = new LinkQueue();
        lqa.offer(10);
        lqa.offer(20);
        lqa.offer(30);
        lqa.offer(40);
        lqa.poll();
        System.out.println("Size of this queue is: " + lqa.size());
        lqa.displayQueue();
    }
}