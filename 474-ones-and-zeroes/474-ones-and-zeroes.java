class Solution {
 int[][][] dp;
public int findMaxForm(String[] strs, int m, int n) {
    dp= new int[m + 1][n + 1][strs.length];
    return helper(strs, m, n, 0);
}
public int helper(String[] str, int m, int n, int idx){
    if(idx == str.length || m + n == 0){
        return 0;
    }
    if(dp[m][n][idx] != 0)return dp[m][n][idx];
    int zeros = countZeros(str[idx]);
    int ones = countOnes(str[idx]);
    int consider = 0;
    if(m >= zeros && n >= ones){
        consider = 1 + helper(str, m - zeros, n - ones, idx + 1);
    }
    int notConsider = helper(str, m, n, idx + 1); 
    
    return dp[m][n][idx] = Math.max(consider, notConsider);

}
  public int countZeros(String str){
    int count = 0;
    for(int i = 0; i < str.length(); i++){
        if(str.charAt(i) == '0'){
            count++;
        } 
    }
    return count;
}
public int countOnes(String str){
    int count = 0;
    for(int i = 0; i < str.length(); i++){
        if(str.charAt(i) == '1'){
            count++;
        }
    }
    return count;
}
}