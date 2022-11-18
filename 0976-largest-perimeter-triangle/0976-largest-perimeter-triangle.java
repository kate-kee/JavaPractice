class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int side=0;
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]+nums[i+1]>nums[i+2])
            side=Math.max(side,nums[i]+nums[i+1]+nums[i+2]);
        }
        return side;
    }
}