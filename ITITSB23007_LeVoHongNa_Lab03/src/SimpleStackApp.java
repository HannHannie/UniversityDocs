import java.util.Stack;

public class SimpleStackApp {
    public static String decimalToOctal(int decimal) {
        Stack<Integer> stack = new Stack<>();
        while (decimal > 0) {
            stack.push(decimal % 8);
            decimal /= 8;
        }

        StringBuilder octal = new StringBuilder();
        while (!stack.isEmpty()) {
            octal.append(stack.pop());
        }

        return octal.toString();
    }

    // Store 2 stacks vào1 stack result
    public static Stack<Integer> concatenateStacks(Stack<Integer> s1, Stack<Integer> s2) {
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> result = new Stack<>();

        while (!s1.isEmpty()) {
            temp.push(s1.pop());
        }

        while (!temp.isEmpty()) {
            int val = temp.pop();
            s1.push(val);
            result.push(val);
        }
        //then temp rỗng
        while (!s2.isEmpty()) {
            temp.push(s2.pop());
        }

        while (!temp.isEmpty()) {
            int val = temp.pop();
            s2.push(val);
            result.push(val);
        }

        return result;
    }

    public static boolean areStacksIdentical(Stack<Integer> s1, Stack<Integer> s2) {
        if (s1.size() != s2.size()) {
            return false;
        }
        //idea: compare elements và bỏ nó vào stack riêng, sau cùng thì trả lại giá trị stacks ban đâu
        Stack<Integer> temp1 = new Stack<>();
        Stack<Integer> temp2 = new Stack<>();
        boolean identical = true;

        while (!s1.isEmpty()) {
            int val1 = s1.pop();
            int val2 = s2.pop();
            temp1.push(val1);
            temp2.push(val2);

            if (val1 != val2) {
                identical = false;
            }
        }

        // Restore the stacks
        while (!temp1.isEmpty()) {
            s1.push(temp1.pop());
            s2.push(temp2.pop());
        }

        return identical;
    }

    public static void main(String[] args) {
        //Decimal to octal
        int decimal = 78;
        System.out.println("Octal of " + decimal + " is: " + decimalToOctal(decimal));

        //Concatenate
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        stack2.push(4);
        stack2.push(5);
        stack2.push(6);

        Stack<Integer> concatenatedStack = concatenateStacks(stack1, stack2);
        System.out.println("Concatenated Stack: " + concatenatedStack);

        //Checking identical
        Stack<Integer> stack3 = new Stack<>();
        Stack<Integer> stack4 = new Stack<>();

        stack3.push(10);
        stack3.push(20);
        stack3.push(30);

        stack4.push(10);
        stack4.push(20);
        stack4.push(30);

        System.out.println("Stacks are identical: " + areStacksIdentical(stack3, stack4));
    }
}
