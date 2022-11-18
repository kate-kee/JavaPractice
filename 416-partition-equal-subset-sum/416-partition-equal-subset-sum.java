class Solution{
public int helper(int n , int arr[] , int sum , int[][]dp){
  
    if(sum < 0){
        return 0;
    }
    
    if(n == 0){
        if(sum == 0){
            return 1;
        }
        else{
            return 0;
        }
    }
    
    if(dp[n][sum] != -1){
        return dp[n][sum];
    }
    
    if(sum >= arr[n-1]){
        
        int include = helper(n-1 , arr , sum-arr[n-1] , dp);
        int exclude = helper(n-1 , arr , sum , dp);
        
        return dp[n][sum] = include | exclude;
    }
    else{
        return dp[n][sum] = helper(n-1 , arr ,sum , dp);
    }
    
}

public boolean canPartition(int[] nums) {
    
    int n = nums.length;
    
    int sum = 0;
    for(int i = 0; i<n; i++){
        sum+=nums[i];
    }
    if(sum%2 != 0){
        return false;
    }
    
    int[][]dp = new int[n+1][sum/2+1];
    for(int []a : dp){
        Arrays.fill(a , -1);
    }
    
    return helper(n , nums , sum/2 , dp) >= 1 ? true : false;
    
}
}