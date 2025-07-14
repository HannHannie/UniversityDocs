import java.util.*;
class NodeP{
    int data;
    NodeP next;

    public NodeP(int data){
        this.data = data;
    }
}

class CircleOfPlayers{
    private NodeP head;
    private NodeP tail;

    //constructor
    public CircleOfPlayers(){
        this.head = null;
        this.tail = null;
    }

    public void insertPlayer(int data){
        NodeP player = new NodeP(data);

        if (head == null){
            head = player;
            tail = player;
            player.next = head;
        } else {
            tail.next = player;
            tail = player;
            tail.next = head;
        }
        //after tail is head
    }

    public void createCircle(int n){
        for (int i = 1; i <= n; i++){
            insertPlayer(i);
        }
    }

    public void eleminate(int step, int start){
        NodeP curr = head;
        NodeP prev = tail;
        while (curr.data != start){
            prev = curr;
            curr = curr.next; //move curr cho tới khi tới start
        }

        System.out.println("Elimination order: ");
        while (curr != curr.next){ //stop khi còn lại 1 ng
            for (int st = 1; st < step; st++){
                prev = curr;
                curr = curr.next;
            }
            System.out.print(curr.data + " ");

            prev.next = curr.next; //xoá cái node ở curr

            if (curr == head){
                //nếu head bị xoá thì update lại head, avoid the logic error
                head = curr.next;
            }
            if (curr == tail){ //tương tự với tail
                tail = prev;
            }

            curr = curr.next;
        }
        System.out.println();

        //when remain 1 player
        System.out.println("Last person standing: " + curr.data);
    }
}

public class JosephusProblem{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of people in the circle: ");
        int numOfPlayers = sc.nextInt();

        System.out.println("Enter the number used for counting off: ");
        int step = sc.nextInt();

        System.out.println("Enter the number of person where counting starts: ");
        int start = sc.nextInt();

        CircleOfPlayers cp = new CircleOfPlayers();
        cp.createCircle(numOfPlayers);
        cp.eleminate(step, start);

        sc.close();
    }
}