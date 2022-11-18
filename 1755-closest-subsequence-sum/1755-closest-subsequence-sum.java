class Solution {
    
    public int getMinAbsDifference(List<Integer> l1, List<Integer> l2, int target){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int len1 = l1.size(), len2 = l2.size();
        for(int i=0; i<len1; i++){
            int x = l1.get(i), low=0, high=len2-1;
            while(low<=high){
                int mid = low + (high-low)/2;
                int sum = x + l2.get(mid);
                if(sum == target){
                    return 0;
                }
                else if(sum < target){
                    low = mid+1;
                    max = Math.max(max,sum);
                }
                else{
                    high = mid-1;
                    min = Math.min(min,sum);
                }
            }
        }
        int result = Math.min(Math.abs(target-min),Math.abs(max-target));
        return result;
    }
    
    public List<Integer> combinationSum(int[] nums, int low, int high){
        List<Integer> result = new ArrayList<>();
        int n = high-low+1, index=0;
        int[] arr = new int[n];
        for(int i=low; i<=high; i++){
            arr[index++] = nums[i];
        }
        for(int i=0; i<(1<<n); i++){
            int sum=0;
            for(int j=0; j<n; j++){
                if((i & (1<<j))!=0){
                    sum += arr[j];
                }
            }
            result.add(sum);
        }
        return result;
    }
    
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int mid = (n-1)/2;
        List<Integer> l1 = combinationSum(nums,0,mid);
        List<Integer> l2 = combinationSum(nums,mid+1,n-1);
        Collections.sort(l2);
        return getMinAbsDifference(l1,l2,goal);
    }
}