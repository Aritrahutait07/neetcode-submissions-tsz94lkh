class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit =  -244;
        //int sell = prices[1];
        for(int R=1;R<prices.length;R++){
            if(buy>prices[R]){
                buy = prices[R];
            }
            if(prices[R]-buy>maxProfit){
                maxProfit = prices[R]-buy;
            }
        }
        return maxProfit > 0 ? maxProfit: 0;
    }
}
