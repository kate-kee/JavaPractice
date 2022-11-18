class MyCalendarThree {
    public Map<Integer,Integer> mp;
    public MyCalendarThree() {
    mp=new TreeMap<Integer,Integer>();
    }
    
    public int book(int start, int end) {
        mp.put(start,mp.getOrDefault(start,0)+1);
        mp.put(end,mp.getOrDefault(end,0)-1);
        int res=0,curr=0;
        for(int d:mp.values()){
            curr+=d;
            res=Math.max(res,curr);
        }
        return res;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */