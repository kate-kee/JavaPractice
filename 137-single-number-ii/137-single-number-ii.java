class Solution {
    public int singleNumber(int[] nums) {
       int max_num=Integer.MIN_VALUE; 
        boolean isNeg=false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                isNeg=true;
                break;
            }
            max_num=Math.max(max_num,nums[i]);
        }
        int len=(int)(Math.log(max_num)/Math.log(2));
        len++;
        if(isNeg==true)
            len=32;
        int digit=0;
        for(int i=0;i<len;i++){
            int one=0;
            for(int j=0;j<nums.length;j++){
                if((nums[j] & 1<<i)==Math.pow(2,i)){
                    one++;
                }
            }
            digit+=(one%3)*(Math.pow(2,i));
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                if(nums[i]==digit+Integer.MAX_VALUE+1){
            digit+=Integer.MAX_VALUE+1;
            break;
            }
            }
        }
        return digit;
    }
}