class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] h = new int[26];
            for(char c : s.toCharArray()){
                h[c-'a']++;
            }
            if(map.containsKey(Arrays.toString(h))){
                map.get(Arrays.toString(h)).add(s);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(Arrays.toString(h),list);
            }
        }

        return new ArrayList<>(map.values());
    }
}