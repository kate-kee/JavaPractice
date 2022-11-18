class Solution {
    public int coinChange(int[] nums, int amount) {
        
        int dp[][]=new int[nums.length][amount+1];
        for(int rows[]:dp)
        {
            Arrays.fill(rows,-1);
        }
        
        int res= MinCoin(nums,amount,nums.length-1,dp);
        return res == (int)1e9 ? -1 : res;
       
    }
    
    public int MinCoin(int [] nums,int amount, int ind,int [][]dp)
    {
        if(ind==0)
        {
            if(amount%nums[ind]==0) return amount/nums[ind];
            else
            return (int)1e9;
        }
        if(amount<0) return -1;
        if(amount==0) return 0;
        
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        
        int nt=MinCoin(nums,amount,ind-1,dp);
        int t=Integer.MAX_VALUE;
        
        if(amount-nums[ind]>=0)
        t=1+MinCoin(nums,amount-nums[ind],ind,dp);
        
        return dp[ind][amount]=Math.min(nt,t);
    }
 }
