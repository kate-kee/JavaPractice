class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff=Integer.MAX_VALUE;

        for(int i=0;i<nums.length && diff!=0;i++){
            int low=i+1;
            int high=nums.length-1;
            
            while(low<high){
                int newsum=nums[i]+nums[low]+nums[high];
                int newdiff=target-newsum;
                if(Math.abs(diff)>Math.abs(newdiff)){
                    diff=newdiff; 
                }
                if(newsum<=target)
                    low++;
                if(newsum>target)
                    high--;
            }
        }
        return target-diff;
        
    }
}