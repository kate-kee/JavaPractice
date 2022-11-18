class MedianFinder {
    double median;
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>((a,b)->{
           return a - b; 
        });
        
        maxHeap = new PriorityQueue<Integer>((a,b)->{
           return b - a; 
        });
        
        median = Double.MAX_VALUE;
    }
    
    public void addNum(int num) {
        if(num < median){
            maxHeap.add(num);
            if(maxHeap.size() - minHeap.size() > 1){
                // rebalance
                minHeap.add(maxHeap.poll());
            }
        }
        else{
            minHeap.add(num);
            if(minHeap.size() - maxHeap.size() > 1){
                // rebalance
                maxHeap.add(minHeap.poll());
            }
        }
        
        // update current median
        median = (maxHeap.size() == minHeap.size()) ? ((maxHeap.peek() + minHeap.peek()) / 2.0)
                                                    : ((maxHeap.size() > minHeap.size()) ? maxHeap.peek() : minHeap.peek());
    }
    
    public double findMedian() {
        return median;
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */