import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class CircularQueue {
    private int maxSize;
    private int[] queueArray;
    private int front, rear, nItems;
    private int[] processingTime;

    public CircularQueue(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        processingTime = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public boolean isFull() {
        return nItems == maxSize;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public void insert(int value, int time) {
        if (isFull()) {
            System.out.println("Full Queue");
            return;
        }
        rear = (rear + 1) % maxSize; // Wraparound
        queueArray[rear] = value;
        processingTime[rear] = time;
        nItems++;
    }

    public void remove() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
            return;
        }
        if (--processingTime[front] <= 0) {
            System.out.println("Delete: " + queueArray[front]);
            front = (front + 1) % maxSize;
            nItems--;
        } else {
            System.out.println("Processing " + queueArray[front] + " (" + processingTime[front] + " sec)");
        }
    }

    public void displayQueueArray() {
        System.out.print("Queue Array: [ ");
        for (int i = 0; i < maxSize; i++) {
            System.out.print(queueArray[i] + " ");
        }
        System.out.println("]");
        System.out.println("Front: " + front + " | Rear: " + rear);
    }

    public void displayQueue() {
        System.out.print("Queue: [ ");
        int tempFront = front;
        for (int i = 0; i < nItems; i++) {
            System.out.print(queueArray[tempFront] + " ");
            tempFront = (tempFront + 1) % maxSize; // Wraparound
        }
        System.out.println("]");
    }
}

public class QueueApp {
    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        Random rand = new Random();

        queue.insert(10, rand.nextInt(3) + 1);
        queue.insert(20, rand.nextInt(3) + 1);
        queue.insert(30, rand.nextInt(3) + 1);
        queue.insert(40, rand.nextInt(3) + 1);
        queue.insert(50, rand.nextInt(3) + 1); // Queue đầy

        queue.displayQueueArray();
        queue.displayQueue();

        for (int i = 0; i < 7; i++) {
            queue.remove();
            queue.displayQueue();
        }
    }
}
