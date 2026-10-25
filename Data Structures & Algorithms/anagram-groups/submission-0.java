class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<String> sorted = new ArrayList<String>();
        for(int i=0;i<strs.length;i++)
        {
        String original = strs[i];
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        sorted.add(new String(chars));
        }


        List<String> set = new ArrayList<String>(new HashSet<String>(sorted));

        List<List<String>> output = new ArrayList<List<String>>(set.size()); 
        
        for(int i=0;i<set.size();i++)
        {
            output.add(new ArrayList<String>());
        }

        for(int i=0;i<strs.length;i++)
        {
            for(int j=0;j<set.size();j++){
                // System.out.println(set.get(j)+","+strs[i]+","+set.get(j).equals(strs[i]));
                if(set.get(j).equals(sorted.get(i))){
                    output.get(j).add(strs[i]);
                    break;
                }
            }   
        }

        
        return output;
    }
}
