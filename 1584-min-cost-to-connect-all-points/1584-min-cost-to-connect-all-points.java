class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> (a.getKey() - b.getKey()));;
        boolean[] inMST = new boolean[n];
        heap.add(new Pair(0, 0));
        int mstCost = 0;
        int edgesUsed = 0;
        while(edgesUsed<n){
            Pair<Integer,Integer> top=heap.poll();
            int weight=top.getKey();
            int currNode=top.getValue();
            if (inMST[currNode]) {
                continue;
            }
            inMST[currNode] = true;
            mstCost += weight;
            edgesUsed++;
            for(int nextNode=0;nextNode<n;nextNode++){
                if(!inMST[nextNode]){
                     int nextWeight = Math.abs(points[currNode][0] - points[nextNode][0]) + 
                     Math.abs(points[currNode][1] - points[nextNode][1]);
        
                    heap.add(new Pair(nextWeight, nextNode));
                }
            }
            
        }
                return mstCost;
        
    }
}