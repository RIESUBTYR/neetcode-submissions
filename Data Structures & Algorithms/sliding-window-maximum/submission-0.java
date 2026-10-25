class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> output = new ArrayList();
        PriorityQueue<Integer> window
            = new PriorityQueue<Integer>(
                Collections.reverseOrder());

        for(int i=0;i<k;i++){
            window.add(nums[i]);
        }
        output.add(window.peek());

        int l=0;

        for(int r=k;r<nums.length;r++){
            //Add to window
            window.add(nums[r]);

            //remove from window
            window.remove(nums[l++]);

            output.add(window.peek());
        }

        return output.stream().mapToInt(Integer::intValue).toArray();
    }
}
