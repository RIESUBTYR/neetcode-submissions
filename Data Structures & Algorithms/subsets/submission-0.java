class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> subsets(int[] nums) {
        list = new ArrayList<>();
        list.add(new ArrayList<Integer>());

        subsets(0,nums,new ArrayList<>());

        return list;
    }

    public void subsets(int index, int[] nums, List<Integer> acc){
        if(index == nums.length){
            return;
        }
        List<Integer> temp = new ArrayList<>(acc);

        subsets(index+1,nums,temp);

        temp.add(nums[index]);
        list.add(temp);

        subsets(index+1,nums,temp);
    }
}
