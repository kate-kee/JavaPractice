
class Pair{
    TreeNode node;
    int l;
    int x;
    
    Pair(TreeNode node ,int l ,int x){
        this.node=node;
        this.l=l;
        this.x=x;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> tm=new TreeMap<>();//(x,l)
        ArrayDeque <Pair> q =new ArrayDeque<>();
        
        q.add(new Pair(root,0,0));
        
        while(q.size()!=0){
           Pair rem =q.remove();
            int x =rem.x;
            int l=rem.l;
    if(!tm.containsKey(x)){
        tm.put(x,new TreeMap<>());
    }
    
    if(!tm.get(x).containsKey(l)){
        tm.get(x).put(l,new PriorityQueue<>());
    }
    tm.get(x).get(l).add(rem.node.val);
    
    if(rem.node.left!=null){
        q.add(new Pair(rem.node.left,l+1,x-1));
    }
    if(rem.node.right!=null){
        q.add(new Pair(rem.node.right,l+1,x+1));
    }
        }
        
         List<List<Integer>> list=new ArrayList<>();
       
         for(TreeMap<Integer,PriorityQueue<Integer>> ys:tm.values()){
             list.add(new ArrayList<>());
             for(PriorityQueue <Integer> nodes :ys.values()) {
                 while(!nodes.isEmpty()){
                     list.get(list.size()-1).add(nodes.poll());
                     
                 }
             }
         }
        
        return list;
    }
}