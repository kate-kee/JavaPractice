class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] prefix=new int[n];
        int[] suffix=new int[n];
        int[] result=new int[n];
        prefix[0]=nums[0];
        suffix[n-1]=nums[n-1];
        for(int x=1;x<n-1;x++){
            prefix[x]=prefix[x-1]*nums[x];
            suffix[n-x-1]=suffix[n-x]*nums[n-x-1];  
        }
        for(int x=0;x<n;x++){
            if(x==0)
                result[x]=suffix[x+1];
            else if(x==n-1)
                result[x]=prefix[x-1];
            else
            result[x]=prefix[x-1]*suffix[x+1];
        }
        return result;
    }
}