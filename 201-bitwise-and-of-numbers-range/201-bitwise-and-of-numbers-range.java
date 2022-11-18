class Solution {
    public int rangeBitwiseAnd(int left, int right) {

        int range=0;
        while((left & right)!=0){
            int left_value=(int)(Math.log(left)/Math.log(2));
            int right_value=(int)(Math.log(right)/Math.log(2));
            left_value++;
            right_value++;
            if(left_value!=right_value)
                break;
            range+=(int)Math.pow(2,left_value-1);
            left=left^(1 << (left_value-1));
            right=right^(1 << (right_value-1));
        }
        return range;
    }
}