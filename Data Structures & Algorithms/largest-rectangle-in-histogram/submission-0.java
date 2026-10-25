class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
            int start = i;
            while(!stack.empty() && heights[i]<stack.peek()[0]){
                int[] pair = stack.pop();
                int index = pair[1];
                int height = pair[0];
                maxArea = Math.max(maxArea,height*(i-index));
                start=index;
            }
            stack.push(new int[]{heights[i],start});
        }

        for(int[] pair:stack){
            int index=pair[1];
            int height=pair[0];
            maxArea = Math.max(maxArea,height*(heights.length-index));
        }

        return maxArea;
    }
}
