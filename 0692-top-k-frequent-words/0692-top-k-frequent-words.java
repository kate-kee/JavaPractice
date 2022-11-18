class Solution {
    public List<String> topKFrequent(String[] words, int k) {
              HashMap<String, Integer> map = new HashMap<>();
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> {
            Integer valueA = map.get(a);
            Integer valueB = map.get(b);
            if (valueA.equals(valueB)) return a.compareTo(b);
            
            return valueB.compareTo(valueA);
        });
        
        
        for(String key: map.keySet()) {
            pq.add(key);
        }
        List<String> result = new ArrayList();
        while(k > 0) {
            result.add(pq.poll());
            k--;
        }
        
        return result;  
    }
}