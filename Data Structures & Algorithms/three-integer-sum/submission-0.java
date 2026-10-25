class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> output = new HashSet<List<Integer>>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int k =j+1;
                while(k<nums.length)
                {
                    if(nums[i]+nums[j]+nums[k]==0)
                    {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.sort(null);
                        output.add(temp);
                    }
                    k++;
                }
            }
        }
        List<List<Integer>> myList = new ArrayList<>();
        myList.addAll(output);
        return myList;
    }
}
