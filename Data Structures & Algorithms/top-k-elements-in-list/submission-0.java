class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap();

        for(int i=0;i<nums.length;i++){
            if(count.get(nums[i]) == null){
                count.put(nums[i],1);
                continue;
            }
            count.put(nums[i],count.get(nums[i])+1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList(count.entrySet());
        list.sort(Map.Entry.comparingByValue());
        int[] output = new int[k];

        for(int i=0;i<k;i++){
            output[i] = list.get(list.size()-1-i).getKey();
        }
        return output;
    }
}
