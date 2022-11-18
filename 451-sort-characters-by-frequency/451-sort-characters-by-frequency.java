class Solution {
    public String frequencySort(String s) {
        if (s == null) return null;
        int[] counts = new int[128];
        for (char c : s.toCharArray()) counts[c]++;
        
        Queue<Pair<Character, Integer>> q = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) q.offer(new Pair((char) i, counts[i]));
        }
        
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Pair<Character, Integer> p = q.poll();
            sb.append(String.valueOf(p.getKey()).repeat(p.getValue()));
        }
        return sb.toString();
    }
}