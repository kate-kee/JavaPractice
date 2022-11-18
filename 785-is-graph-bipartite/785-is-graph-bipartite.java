class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        for(int i=0;i<n;i++){
            color[i]=-1;
        }
     
        for(int i=0;i<n;i++){
            if(color[i]==-1)
            if(!bfs(i,color,graph))
                return false;
        }
        return true;
    }
      public boolean bfs(int ve, int[] color, int[][] graph){
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(ve);
        color[ve]=1;
        while(!q.isEmpty()){
            int v=q.poll();
            for(int adjVer:graph[v]){
                if(color[adjVer]==color[v])
                    return false;
                else if(color[adjVer]==-1){
                    q.offer(adjVer);
                    color[adjVer]=(color[v]==0?1:0);
                }
            }
        }
    return true;
    }
}