class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> rev = new HashMap();
        rev.put('(',')');
        rev.put('{','}');
        rev.put('[',']');
        Stack<Character> bracket = new Stack();

        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                bracket.push(ch);
            }
            else if((ch == ')' || ch == '}' || ch == ']') && !bracket.empty()){
                char c= bracket.peek();
                if(rev.get(c) == ch){
                    bracket.pop();
                }
                else{
                    return false;
                }
            }
            else if((ch == ')' || ch == '}' || ch == ']') && bracket.empty()){
                return false;
            }
        }

        if(bracket.empty()){
            return true;
        }

        return false;
    }
}  
