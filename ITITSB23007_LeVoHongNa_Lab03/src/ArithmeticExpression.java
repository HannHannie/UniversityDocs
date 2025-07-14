import java.util.*;

public class ArithmeticExpression {

    //chuyển chuỗi expression thành postfix
    static List<String> infixToPostfix(String expr) {
        Stack<Character> ops = new Stack<>();
        List<String> postfix = new ArrayList<>(); //

        int i = 0;
        while (i < expr.length()) {
            char c = expr.charAt(i); // gán c bằng char ở vị trí i

            if (Character.isDigit(c)) { //check xem c có phải là số không
                StringBuilder num = new StringBuilder();
                while (i < expr.length() && Character.isDigit(expr.charAt(i))) num.append(expr.charAt(i++));
                postfix.add(num.toString());
                continue;
            }

            if (Character.isLetter(c)) {
                StringBuilder var = new StringBuilder();
                while (i < expr.length() && Character.isLetter(expr.charAt(i))) var.append(expr.charAt(i++));
                postfix.add(var.toString());
                continue;
            }

            if (c == '(') ops.push(c);
            else if (c == ')') while (!ops.isEmpty() && ops.peek() != '(') postfix.add(String.valueOf(ops.pop()));
            else {
                while (!ops.isEmpty() && precedence(ops.peek()) >= precedence(c)) postfix.add(String.valueOf(ops.pop()));
                ops.push(c);
            }
            i++;
        }
//========================================
        while (!ops.isEmpty()) postfix.add(String.valueOf(ops.pop()));
        return postfix; //trả giá trị về chuỗi postfix
    }

    static int precedence(char op) {
        return (op == '+' || op == '-') ? 1 : (op == '*' || op == '/') ? 2 : 0;
    }

    static int evaluatePostfix(List<String> postfix, Map<String, Integer> vars) {
        Stack<Integer> stack = new Stack<>();
        for (String token : postfix) {
            if (token.matches("\\d+")) stack.push(Integer.parseInt(token));
            else if (token.matches("[a-zA-Z]+")) stack.push(vars.get(token));
            else {
                int b = stack.pop(), a = stack.pop();
                stack.push(token.equals("+") ? a + b : token.equals("-") ? a - b :
                        token.equals("*") ? a * b : a / b);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the expression: ");
        String expr = sc.nextLine().replaceAll("\\s+", ""); //xoá tất cả các space

        List<String> postfix = infixToPostfix(expr); //chuyển infix thành postfix
        System.out.println("Expression: " + postfix); //in postfix ra màn hình

        Map<String, Integer> vars = new HashMap<>(); //dùng hashmap để truy xuất giá trị

        //dò trong postfix cái nào là chữ cái để input giá trị cho nó
        for (String token : postfix) {
            if (token.matches("[a-zA-Z]+") && !vars.containsKey(token)) {
                System.out.print("Input the value of " + token + ": ");
                vars.put(token, sc.nextInt()); //gán giá trị cho token từ bàn phím vào vars
            }
        }

        System.out.println("Result: " + evaluatePostfix(postfix, vars));
        sc.close();
    }
}
