class NumArray {
    int nums[];
    int sumRange[];
    public NumArray(int[] nums) {
        this.nums=nums;
        getPrefixArray(nums);
    }
    public void getPrefixArray(int nums[]){
        sumRange=new int[nums.length+1];
        sumRange[0]=0;
        for(int i=1;i<=nums.length;i++){
            sumRange[i]=nums[i-1]+sumRange[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return sumRange[right+1]-sumRange[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */