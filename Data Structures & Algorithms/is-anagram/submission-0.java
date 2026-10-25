class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> smap = new HashMap();
        HashMap<Character,Integer> tmap = new HashMap();
        if(s.length() != t.length()) return false;
        for(int i =0;i<s.length();i++){
            if(!smap.containsKey(s.charAt(i))){
                smap.put(s.charAt(i),1);
            }
            else {
                int count= smap.get(s.charAt(i));
                smap.put(s.charAt(i),count+1);
            }

            if(!tmap.containsKey(t.charAt(i))){
                tmap.put(t.charAt(i),1);
            }
            else {
                int count= tmap.get(t.charAt(i));
                tmap.put(t.charAt(i),count+1);
            }
        }


        return smap.equals(tmap);
    }
}
