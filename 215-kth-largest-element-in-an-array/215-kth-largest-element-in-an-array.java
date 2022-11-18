class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();

        for(int num:nums){
            if(pq.size()<k){
                pq.add(num);
            }
            else{
                pq.add(Math.max(pq.poll(),num));
            }
        }
        return pq.peek();
    }
}