class Solution {
    public int[] decode(int[] encoded) {
        int max_num=encoded.length+1;
        int[] original=new int[max_num];
        int j=1;
        if(max_num%4==1){
            original[0]=1;
        }
        else{
             original[0]=0;
        }
        for(int i=1;i<max_num;i=i+2){
            original[0]^=encoded[i];
        }
        while(j<max_num){ 
            original[j]=original[j-1]^encoded[j-1];
            j++;
        }
        return original;
    }
}