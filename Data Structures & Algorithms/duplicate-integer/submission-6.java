class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i =0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
            else if(map.get(nums[i]) == 1){
                return true;
            }
        }
        return false;
    }
}
