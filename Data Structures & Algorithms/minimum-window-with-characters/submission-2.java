class Solution {
    public String minWindow(String s, String t) {

        if(s.length()<t.length()){
            return "";
        }

        int minLength = s.length();

        HashMap<Character,Integer> countS= new HashMap();
        HashMap<Character,Integer> countT= new HashMap();

        for(int i=0;i<t.length();i++){
            if(countT.containsKey(t.charAt(i))){
                countT.put(t.charAt(i),countT.get(t.charAt(i))+1);
            }else{
                countT.put(t.charAt(i),1);
                countS.put(t.charAt(i),0);
            }
        }
        
        int matches = 0;

        String output = "";
        int l =0;

        for(int r=0;r<s.length();r++){

            if(countS.containsKey(s.charAt(r))){
                countS.put(s.charAt(r),countS.get(s.charAt(r))+1);
                if(countS.get(s.charAt(r))==countT.get(s.charAt(r))){
                    matches++;
                }
            }
            
            while(matches == countT.size()){
                System.out.println("Length="+(r-l+1));
                if(r-l+1<=minLength){
                    output = s.substring(l,r+1);
                    System.out.println(output);
                    minLength = output.length();
                }
                if(countS.containsKey(s.charAt(l))){
                    countS.put(s.charAt(l),countS.get(s.charAt(l))-1);
                    if(countS.get(s.charAt(l))<countT.get(s.charAt(l)))
                    {
                        matches--;
                    }
                }
                l++;
            }

            System.out.println(matches);
            System.out.printf("%d,%d\n",l,r);
        }

        return output;
        
    }
}
