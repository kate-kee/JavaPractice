public class insertionSort {
    public static void sort(int nums[]){
        for(int i = 1; i < nums.length; i++){ 
            int j=i-1;
            int key=nums[i];
            while(j>=0 && nums[j]>key){
                nums[j+1]=nums[j];
                j--;
            }
                nums[j+1]=key;
            }
            for(int n:nums){
                System.out.println(n);
            }
        }

    public static void main(String[] args) {
        int[] a={10,3,4,5,6,7,8,9};
        sort(a);
    }
}
