class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length==0){
            return 0;
        }

        Set<Integer> set= new TreeSet<Integer>();

        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        int max=1;
        int length=1;
        int pre=Integer.MIN_VALUE;
        
        for(int num:set){
            System.out.println(pre+","+num);
            if(pre == Integer.MIN_VALUE){
                pre=num;
                continue;
            }
            if(num-pre==1){
                length++;
            }
            else{
                length=1;
            }
            if(length>max){
                max=length;
            }
            pre = num;
        }

        return max;
    }
}
