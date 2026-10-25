class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int ind1=0;
        int ind2=numbers.length-1;


        while(ind1<ind2){
            int sum=numbers[ind1]+numbers[ind2];

            if(sum>target){
                ind2--;
            }
            else if(sum<target){
                ind1++;
            }
            else{
                return new int[]{ind1+1,ind2+1};
            }
        }

        return new int[]{-1,-1};
    }
}
