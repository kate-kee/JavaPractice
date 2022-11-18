class Solution {
    
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color=new int[n+1];
        List<Integer>[] adj=new LinkedList[n+1];
        for(int i=0;i<=n;i++){
            color[i]=-1;
        }
        for(int i=0;i<=n;i++){
            adj[i]=new LinkedList<Integer>();
        }
        for(int[] edge:dislikes){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        
        for(int i= 1;i<=n;i++){
            if(color[i]==-1)
            if(!bfs(i,color,adj))
                return false;
        }
        return true;
    }
    public boolean bfs(int ve, int[] color, List<Integer>[] adj){
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(ve);
        color[ve]=1;
        while(!q.isEmpty()){
            int v=q.poll();
            for(int adjVer:adj[v]){
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