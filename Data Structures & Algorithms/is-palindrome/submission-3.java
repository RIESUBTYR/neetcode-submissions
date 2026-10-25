class Solution {
    public boolean isPalindrome(String s) {
        
        int p1= 0;
        String s1 = s.replace(" ","");
        int p2= s1.length()-1;
        while(p1<p2){
            if(!Character.isLetterOrDigit(s1.charAt(p1))){
                p1++;
                continue;
            }
            if(!Character.isLetterOrDigit(s1.charAt(p2))){
                p2--;
                continue;
            }
            if(Character.toLowerCase(s1.charAt(p1)) == Character.toLowerCase(s1.charAt(p2))){
                p1++;
                p2--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
