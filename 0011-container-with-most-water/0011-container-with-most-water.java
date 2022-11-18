class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxval=0;
        int max_real=Integer.MIN_VALUE;
        while(left<right){
            if(height[left]<height[right]){
                maxval=height[left]*(right-left);
                left++;
            }
            else{
                maxval=height[right]*(right-left);
                right--;
            }
            max_real=Math.max(max_real,maxval);
        }
        return max_real;
    }
}