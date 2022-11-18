class Solution {
    int[] arr1;
    int[] arr2;
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length>nums1.length)
            return findMedianSortedArrays(nums2,nums1);
        arr1=nums1; 
        arr2=nums2;
        mergeArrays();
        if(arr1.length==arr2.length)
            return (double)(arr1[arr1.length-1] + arr2[0])/2;
//         if(arr2.length==0){
            
//             if(arr1.length%2==0){
//             int mid1=(arr1.length)/2;
//             int mid2=(arr1.length-1)/2; 
//             return (double)(arr1[mid1]+arr1[mid2])/2; 
//             }
            
//             else
//                 return (double) arr1[arr1.length/2];
//         }
           
        if((arr1.length+arr2.length)%2==0){
            int mid1=(arr1.length+arr2.length)/2;
            int mid2=(arr1.length+arr2.length-1)/2;
                return (double)(arr1[mid1]+arr1[mid2])/2;                  
        }
        else
            return (double)arr1[(arr1.length+arr2.length)/2];
       
    }
    public void mergeArrays(){
        for (int i=arr2.length-1; i>=0; i--)
        {
            int j, last = arr1[arr1.length-1];
            for (j=arr1.length-2; j >= 0 && arr1[j] > arr2[i]; j--)
                arr1[j+1] = arr1[j];
            if (last > arr2[i])
            {
                arr1[j+1] = arr2[i];
                arr2[i] = last;
            }
        }
    }
}