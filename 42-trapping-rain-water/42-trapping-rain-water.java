class Solution {
    public int trap(int[] height) {
         int left = 0;
        int right = height.length-1;
        int maxLeft = height[left];
        int maxRight = height[right];
        int count = 0;

        while(left<right){
            if(maxLeft <= maxRight){
                left++;
                if(maxLeft-height[left]>0)
                    count += maxLeft-height[left];
                else 
                    maxLeft = height[left];     
            }
            else {
                right--;
                if(maxRight-height[right]>0)
                    count += maxRight-height[right];
                else 
                    maxRight = height[right];
                
            }
           
        }
        return count;
    }
}