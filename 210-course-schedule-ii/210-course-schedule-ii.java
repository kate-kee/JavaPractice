class Solution {
    public static Stack<Integer> st;
    public static boolean visited[];
        public static int visited1[];

    public boolean checkCycle(List<Integer>[] adj,int curr){
        if(visited1[curr]==2)
                return true;
            visited1[curr]=2;
            for(int i=0;i<adj[curr].size();i++){
                if(visited1[adj[curr].get(i)]!=1)
                    if(checkCycle(adj,adj[curr].get(i)))
                        return true;
            }
            visited1[curr]=1;
            return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj=new LinkedList[numCourses];
        this.visited=new boolean[numCourses];
        this.visited1=new int[numCourses];

        this.st=new Stack<Integer>();
        for(int i=0;i<numCourses;i++){
            adj[i]=new LinkedList<Integer>();
        }
        for(int i=0;i<prerequisites.length;i++){
            adj[prerequisites[i][1]].add(prerequisites[i][0]); //0->1
        }
        for(int i=0;i<numCourses;i++){
            if(visited1[i]!=2){
          if(checkCycle(adj,i))
              return new int[0];
            }
        }
        for(int i=0;i<numCourses;i++){
          dfs(adj,i);
        }
        int[] res=new int[numCourses];
        int id=0;
        while(!st.isEmpty()){
            res[id++]=st.pop();
        }
        return res;
    }
    public void dfs(List<Integer>[] adj, int curr){
        if(visited[curr]==true)
            return;
        for(int i:adj[curr]){
            dfs(adj,i);
        }
        st.add(curr);
        visited[curr]=true;
        return;
    }
}