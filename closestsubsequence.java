public class closestsubsequence {
    static int[] a=new int[200];
    static int[] b=new int[200];
    
    static void calcSubarrays(int[] nums, int[] a,int start, int end){
        for(int i=0;i<(1<<end);i++){
        int s=0;
            for(int j=0;j<end;j++)
                if((i&(1<<j))==1)
                    s+=nums[j+start];
            a[i]=s;
        }
        
    }
    public static int minAbsDifference(int[] nums, int goal) {
        int n=nums.length;
        calcSubarrays(nums,a,0,n/2);
        calcSubarrays(nums,b,(n/2)+1,n-1);
        //for(int x:a)
       // System.out.println(x);
        for(int x:b)
        System.out.println(x);
        return 0;
    }
    public static void main(String[] args){
        int[] nums={5,-7,3,5};
        minAbsDifference(nums,6);
    }
}
