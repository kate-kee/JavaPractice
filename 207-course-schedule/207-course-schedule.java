class Solution {
    public static int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
     List<Integer>[] graph = new LinkedList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new LinkedList<Integer>();
        }
        for(int[] prerequisite : prerequisites){
            graph[prerequisite[1]].add(prerequisite[0]);
        this.visited=new int[numCourses];
            for(int i=0;i<numCourses;i++){
              if(visited[i]==0){
                  if(checkCycle(graph,i))
                      return false;
              }
            }
        }
            return true;
        }
        public boolean checkCycle(List<Integer>[] graph,int curr){
            if(visited[curr]==2)
                return true;
             if(visited[curr]==1)
                return false;
            visited[curr]=2;
            for(int i=0;i<graph[curr].size();i++){
                if(visited[graph[curr].get(i)]!=1)
                    if(checkCycle(graph,graph[curr].get(i)))
                        return true;
            }
            visited[curr]=1;
            return false;
        }
        
        
}