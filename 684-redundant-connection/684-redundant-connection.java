class Solution {
    static int parent[];
    public int[] findRedundantConnection(int[][] edges) {
   this.parent=new int[edges.length+1];

    for(int i=0;i<=edges.length;i++){
       parent[i]=-1; 
    }
        int ans[]=new int[2];
    for(int i=0;i<edges.length;i++){
        int a=edges[i][0];
        int b=edges[i][1];
        if(find(a)==find(b)){
            ans[0]=a;
            ans[1]=b;
        }
        else{
            union(a,b);
        }
    }
        return ans;
    }
    public static int find(int a){
        if(parent[a]==-1)
            return a;
        return find(parent[a]);
    }
    public static void union(int x,int y){
        int pX=find(x);
        int pY=find(y);
        if(pX==pY)
            return;
        parent[pX]=pY;
        
    }
}