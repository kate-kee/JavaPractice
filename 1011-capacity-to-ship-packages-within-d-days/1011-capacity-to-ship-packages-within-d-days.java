class Solution {
    public int shipWithinDays(int[] weights, int days) {
                int start=1;
        int end=0;
        for(int i:weights){
            if(start<i)
                start=i;
            end+=i;
        }
        while(start<=end){
            int mid=start+(end-start)/2;
            int tot=0;
            int count=1;
            for(int k:weights){
                tot+=k;
                if(tot>mid){
                    count++;
                    tot=k;
                }
            }
            if(count>days){
                start=mid+1;
            }
            else 
            {
                end=mid-1;
            }
        }
        return start;
    }
}