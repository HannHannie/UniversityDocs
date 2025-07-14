//hiểu ròiiiiii

/*StackApp.java
 Write methods to display the stack array and the stack itself. Use them to trace the stack operation.
 Extend the push and pop methods to deal with a full and empty stack.
*/

/*how to implement Stack:
put pointer = -1
add element and increase pointer
pointer only at the top element
*/

class Stacking {
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor: Create Stack with size
    public Stacking(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1; // put the pointer at -1
    }

    //check Stack is empty or not
    public boolean isEmpty() {
        return top == -1;
    }

    //check Stack is full or not
    public boolean isFull() {
        return top == maxSize - 1;
    }


    public void push(int value) {
        //check if the stack is full or not
        if (isFull()) {
            //if full, print:
            System.out.println("Full stack, cannot add " + value);
            return;
        }
        // if not full, increase pointer by 1 and add the value
        stackArray[++top] = value; //tăng pointer lên 1 rồi mới lấy giá trị
        System.out.println("Pushed: " + value);
    }

    public int pop() {
        //Similarly, check if the stack empty or not
        if (isEmpty()) {
            System.out.println("Empty Stack");
            //return 1 if stack is empty
            return -1;
        }
        int value = stackArray[top--]; // lấy giá trị của pointer trước rồi mới tăng lên
        System.out.println("Popped: " + value);
        return value;
    }

    //display stack xuôi (từ trái qua phải)
    public void displayStackArray() {
        System.out.print("Stack Array: [ ");
        for (int i = 0; i < maxSize; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println("]");
        System.out.println("Top index: " + top);
    }

    //display stack ngược (từ phải qua trái)
    public void displayStack() {
        System.out.print("Stack: [ ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println("]");
    }
}

public class StackApp {
    public static void main(String[] args) {
        Stacking stack = new Stacking(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        stack.push(60);

        stack.displayStackArray();
        stack.displayStack();

        stack.pop();
        stack.pop();

        stack.displayStack();
    }
}
