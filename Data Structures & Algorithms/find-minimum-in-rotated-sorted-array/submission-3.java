class Solution {
    public int findMin(int[] nums) {
        int n =nums.length;

        int begin =0;
        int end =n-1;

        if(nums[begin]<=nums[end] ){
            return nums[begin];
        }

        while(begin<=end)
        {
            int mid = (begin+end)/2;
            System.out.printf("%d,%d,%d\n",begin,mid,end);
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            if(nums[begin]<nums[mid]){
                begin=mid+1;
            }
            if(nums[mid]<nums[end]){
                end =mid-1;
            }

        }

        return 0;
    }
}
