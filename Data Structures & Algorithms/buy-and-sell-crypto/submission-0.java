class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minprice = prices[0];
        int maxProfit = 0;
        for(int i = 1;i<n;i++){
            int profit = prices[i] - minprice;
            if(maxProfit<profit){
                maxProfit = profit;
            }
            if(prices[i]<minprice){
                minprice = prices[i]; 
            }
        }
        return maxProfit;
    }
}
