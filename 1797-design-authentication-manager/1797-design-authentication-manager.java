

class AuthenticationManager {
    public int timeToLive;
    Map<String,Integer> t_list;
    public AuthenticationManager(int timeToLive) {
        this.timeToLive=timeToLive;
        t_list=new HashMap<String,Integer>();
    }
    
    public void generate(String tokenId, int currentTime) {
        t_list.put(tokenId,currentTime+timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(!t_list.containsKey(tokenId))
            return;
        else{
            if(currentTime>=t_list.get(tokenId)){
                return;
            }
            else
                t_list.put(tokenId,currentTime+timeToLive);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count=0;
        for(Map.Entry<String, Integer> entry : t_list.entrySet()){
            if(entry.getValue()>currentTime)
                count++;
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */