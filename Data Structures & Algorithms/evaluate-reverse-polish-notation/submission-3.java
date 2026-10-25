class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(String token:tokens){
            if(isNumeric(token)){
                stack.push(Integer.parseInt(token));
            }
            else{
                int a= stack.pop();
                int b= stack.pop();
                int c=0;
                System.out.println(b+","+token+","+a);
                if(token.equals("+")){
                    c=a+b;
                }
                else if(token.equals("-")){
                    c=b-a;
                }
                else if(token.equals("*")){
                    c=b*a;
                }
                else if(token.equals("/")){
                    c=b/a;
                }
                stack.push(c);
            }
        }

        return stack.pop();
    }
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
}
