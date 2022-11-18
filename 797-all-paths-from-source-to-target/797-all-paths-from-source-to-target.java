class Solution {
    int target;
    List<List<Integer>> res;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n=graph.length;
        this.target=n-1;
        res=new LinkedList<List<Integer>>();
        List<Integer> l=new LinkedList<Integer>();
        l.add(0);
        dfs(0,graph,l);
       return res; 
    }
    public void dfs(int vertex, int[][] graph,List<Integer> l){
        if(vertex==target){
            res.add(new LinkedList(l));
            return;
        }
        for(int adj_vertex: graph[vertex]){
            l.add(adj_vertex);
            dfs(adj_vertex,graph,l);
            l.remove(l.size()-1);
        }
    }
}