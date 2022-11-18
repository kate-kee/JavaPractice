class Solution {
    public int maxProfit(int[] prices) {
        int maxiProfit=0,leastPrice=prices[0];
      for(int i=0;i<prices.length;i++){
          leastPrice=Math.min(leastPrice,prices[i]);
          maxiProfit=Math.max(maxiProfit,prices[i]-leastPrice);
      }
        return maxiProfit;
    }
}