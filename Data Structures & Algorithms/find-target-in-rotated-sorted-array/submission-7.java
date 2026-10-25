class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;

        int begin =0;
        int end = n-1;
        int mid=0;
        while(begin<end){
            mid = (begin+end)/2;

            if(nums[mid]>nums[end]){
                begin = mid+1;
            }
            else{
                end = mid;
            }
        }
        
        int begin1 =0;
        int end1 = begin-1;
        while(begin1<=end1)
        {
            int mid1 = (begin1+end1)/2;

            if(nums[mid1] == target){
                return mid1;
            }
            if(nums[mid1] > target){
                end1 = mid1-1;
            }
            else{
                begin1 = mid1+1;
            }
        }

        int begin2 = begin;
        int end2 = n-1;
        while(begin2<=end2)
        {
            int mid2 = (begin2+end2)/2;

            if(nums[mid2] == target){
                return mid2;
            }
            if(nums[mid2] > target){
                end2 = mid2-1;
            }
            else{
                begin2 = mid2+1;
            }
        }

        return -1;

    }
}
