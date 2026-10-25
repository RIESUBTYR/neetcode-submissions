class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for(int i=0;i<temperatures.length;i++){
            int t = temperatures[i];
            while(!stack.empty() && t>stack.peek()[0]){
                int[] pop = stack.pop();
                res[pop[1]] = i - pop[1];
            }
            stack.push(new int[]{t,i});
        }
    
        return res;
    }
}
