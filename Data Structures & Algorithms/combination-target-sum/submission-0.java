class Solution {
    List<List<Integer>>  list;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        list = new ArrayList<>();
        List<Integer> cur = new ArrayList();
        combinationSum(nums,0,target, cur);

        return list;
    }

    public void combinationSum(int[] nums,int index,int target,List<Integer> sub){
        if(target == 0){
            list.add(new ArrayList(sub));
            return;
        }
        if(index >= nums.length || target < 0 ){
            return;
        }
        sub.add(nums[index]);
        combinationSum(nums,index,target-nums[index],sub);
        sub.remove(sub.size()-1);
        combinationSum(nums,index+1,target,sub);
    }
}
