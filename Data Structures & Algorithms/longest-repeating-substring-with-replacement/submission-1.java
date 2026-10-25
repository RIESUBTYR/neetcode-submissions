class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet();
        int maxL=0;

        for(char c:s.toCharArray()){
            set.add(c);
        }

        for(char c:set){
            int count = 0; int l =0;

            for(int r=0;r<s.length();r++){
                if(s.charAt(r) == c){
                    count++;
                }

                while((r-l+1)-count>k){
                    if(s.charAt(l)==c){
                        count--;
                    }
                    l++;
                }
                maxL = Math.max(maxL,r-l+1);
            }
        }

        return maxL;
        
    }
}
