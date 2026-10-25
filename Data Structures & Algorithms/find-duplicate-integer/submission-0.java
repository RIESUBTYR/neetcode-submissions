class Solution {
    public int findDuplicate(int[] nums) {
        int n= nums.length;
        int[] count = new int[n];
        for(int i=0;i<n;i++)
        {
            if(count[nums[i]-1]!=0) return nums[i];
            count[nums[i]-1] = count[nums[i]-1] +1;
        }
        return 0;
    }
}
