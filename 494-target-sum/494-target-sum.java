class Solution {
    int total;
    int sum;
    public int findTargetSumWays(int[] nums, int S) {
        total = Arrays.stream(nums).sum();
        sum=S;
        int[][] memo=new int[nums.length][2*total+1];
        for(int[] a:memo){
            Arrays.fill(a,Integer.MIN_VALUE);
        }
        return helper(nums,memo,0,0);
        
    }
    public int helper(int[] nums,int[][] memo,int curr_sum,int idx){
        if(idx==nums.length){
        if(curr_sum==sum)
        {
        return 1;
        }
         else
            return 0;
        }
        else{
            if(memo[idx][total+curr_sum]!=Integer.MIN_VALUE)
                return memo[idx][total+curr_sum];
            int neg=helper(nums,memo,curr_sum-nums[idx],idx+1);
            int pos=helper(nums,memo,curr_sum+nums[idx],idx+1);
            memo[idx][curr_sum+total]=pos+neg;
        return memo[idx][curr_sum+total];
        }  
    } 
}
