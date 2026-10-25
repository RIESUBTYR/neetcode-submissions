class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()) return false;

        int[] count = new int[26];
        int window = s1.length();

        for(char c:s1.toCharArray()){
            count[(int)(c-'a')] +=1;
        }

        for(int i = 0;i<s2.length()-window+1;i++){
            int[] subcount = new int[26];
            for(int j=0;j<window;j++){
                subcount[(int)(s2.charAt(i+j)-'a')] +=1;
            }
            boolean allPass=true;
            
            for(int j=0;j<26;j++){
                if(count[j] != subcount[j]){
                    allPass=false;
                }
            }

            if(allPass){
                return true;
            }
        }

        return false;

    }
}
