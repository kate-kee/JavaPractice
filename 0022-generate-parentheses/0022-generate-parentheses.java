class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res=new ArrayList<String>();
        makeString(n,0,0,new StringBuilder());
        return res;
    }
    public void makeString(int n,int open, int close, StringBuilder s)      {
        if(s.length()==n*2){
            res.add(s.toString());
            return;
        }
        if(open<n){
            s.append("(");
            makeString(n,open+1,close,s);
            s.deleteCharAt(s.length()-1);
                
        }
        if(close<open){
            s.append(")");
            makeString(n,open,close+1,s);
            s.deleteCharAt(s.length()-1);
                
        }
    }
}