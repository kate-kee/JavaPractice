class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0)
            return 0;
        
        int n = prices.length, max;
        int[] prevLine = new int[n];
        int[] dp = new int[n];
        
        for(int i = 1; i <= k; i++){
            dp = new int[n];
			//max represents my maximum profit so far by making i-1 transactions
            max = - prices[0];
            for(int j = 1; j < n; j++){
                dp[j] = Math.max(dp[j-1], max + prices[j]);
                max = Math.max(max,  prevLine[j] - prices[j]);
            }
            prevLine = dp;
        }
        
        return dp[n-1];
    }
}