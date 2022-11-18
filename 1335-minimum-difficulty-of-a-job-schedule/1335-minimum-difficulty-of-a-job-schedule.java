class Solution {
        public int find(int[] arr,int idx,int d,int[][] dp){
        if(d<0) return 100000000;
        if(idx>=arr.length){
            if(d==0) return 0;
            return 100000000;
        }
        if(dp[idx][d]!=-1) return dp[idx][d];
        int ans = Integer.MAX_VALUE;
        int curMax = Integer.MIN_VALUE;
        for(int i=idx;i<arr.length;i++){
            curMax = Math.max(curMax,arr[i]);
            ans = Math.min(ans,curMax+find(arr,i+1,d-1,dp));
        }
        return dp[idx][d] = ans;
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        int[][] dp = new int[n][d+1];
        for(int[] i:dp) Arrays.fill(i,-1);
        int res = find(jobDifficulty,0,d,dp);
        return res>= 100000000 ? -1 : res;
    }
}