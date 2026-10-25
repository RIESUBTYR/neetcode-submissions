class Solution {
    public int maxProfit(int[] prices) {

        if(prices.length == 1){
            return 0;
        }

        int maxProfit = 0;
        int buytime = 0;
        int selltime = 1;

        while(buytime<selltime && selltime<prices.length){
            System.out.println(buytime+","+selltime);
            int profit = prices[selltime] - prices[buytime];

            if(profit<0){
                buytime = selltime;
                selltime++;
                continue;
            }

            if(profit>maxProfit){
                maxProfit = profit;
            }

            selltime++;
        }

        return maxProfit;
    }
}
