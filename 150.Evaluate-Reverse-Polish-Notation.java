class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch(tokens[i]) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num2 - num1;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                        // System.out.println(res);
                    case "/":
                        res = num2 / num1;    
                        break;
                }
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
