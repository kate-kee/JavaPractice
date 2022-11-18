class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num: nums)
            hm.put(num,hm.getOrDefault(num,0)+1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            int key=entry.getKey();
            int value=entry.getValue();
            if(pq.size()<k){
                pq.add(new int[]{key,value});
            }
            else{
                if(pq.peek()[1]<value){
                    pq.poll();
                    pq.add(new int[]{key,value});
                }
            }
        }
        int[] res = new int[k];
        int index = 0;
        while(!pq.isEmpty()){
            res[index++] = pq.remove()[0];
        }
        return res;
    }
}