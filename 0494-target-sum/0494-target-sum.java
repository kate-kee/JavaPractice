class Solution {
    int[][] dp;
    int total;
    public int findTargetSumWays(int[] nums, int target) {
        total=Arrays.stream(nums).sum();
        dp=new int[nums.length][2*total+1];
        for(int[] row:dp)
        Arrays.fill(row,Integer.MIN_VALUE);
        return findSubsets(nums,target,0,0);
    }
    
    public int findSubsets(int[] nums,int target,int i,int curr_sum){
        if(i==nums.length){
            if(target==curr_sum)
                return 1;
            else
                return 0;
        }
        if(dp[i][total+curr_sum]!=Integer.MIN_VALUE){
            return dp[i][total+curr_sum];
        }
        int add=findSubsets(nums,target,i+1,curr_sum+nums[i]);
        int sub=findSubsets(nums,target,i+1,curr_sum-nums[i]);
        dp[i][total+curr_sum]=add+sub;
        return dp[i][total+curr_sum];
    }
}
