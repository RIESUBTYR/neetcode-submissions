class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int product = 1;
        int isZeroCount = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                isZeroCount++;
                continue;
            }
            product*=nums[i];
        }

        int[] output = new int[nums.length];
        
        if(isZeroCount>1){
            return output;
        }

        for(int i=0;i<nums.length;i++){
            if(isZeroCount>0){
                output[i]= nums[i]==0?product:0;
            }
            else{
                output[i]=product/nums[i];
            }
        }

        return output;
    }
}  
