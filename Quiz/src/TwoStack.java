import java.util.*;

public class TwoStack {
    //implement từ LIFO của stack thành FIFO của queue
    private Stack Enqueue = new Stack<>();
    private Stack Dequeue = new Stack<>();

    public void enqueue(int n){
        Enqueue.push(n);
    }

    public void dequeue(){
        reverseStack();
        if(!Dequeue.isEmpty()){
            Dequeue.pop();
        }
    }

    private void reverseStack(){
        if(Dequeue.isEmpty()){
            while(!Enqueue.isEmpty()){
                Dequeue.push(Enqueue.pop());
            }
        }
    }

    public void printFrontElement(){
        reverseStack();
        if(!Dequeue.isEmpty()){
            System.out.println(Dequeue.peek());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        TwoStack twoStackQueue = new TwoStack();
        int count = sc.nextInt();

        for(int i = 0; i < count; i++){
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    int enqueueNumber = sc.nextInt();
                    twoStackQueue.enqueue(enqueueNumber);
                    break;
                case 2:
                    twoStackQueue.dequeue();
                    break;
                case 3:
                    twoStackQueue.printFrontElement();
                    break;
            }
        }
        sc.close();
    }
}