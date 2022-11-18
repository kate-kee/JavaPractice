class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
         Arrays.sort(edges, (a, b) -> Integer.compare(b[0], a[0]));
     int [] aparent=new int [n+1];
     int [] bparent=new int[n+1];
     
     int [] arank=new int[n+1];
     int [] brank=new int[n+1];
     
     for(int i =1;i<=n;i++){//1 based indexing hogi
         aparent[i]=i;
         bparent[i]=i;
         
         arank[i]=1;
         brank[i]=1;
         
     }
     
     int amerged=1;//as pehle merging mai 2 elements lagte hai
     int bmerged=1;//as pehle merging mai 2 elements lagte hai
     
     int removeEdges=0;
     for(int [] a:edges){
         if(a[0]==3){
           boolean alice=union(a[1],a[2],aparent,arank);
           boolean bob=union(a[1],a[2],bparent,brank);
           
           if(alice==true){//i.e merging is happing btw the 2 elements
             amerged++;  
           }
           if(bob==true){//i.e merging is happing btw the 2 elements
              bmerged++; 
           }
           
           if(alice==false && bob==false){//i.e merging is not happing btw the 2 elements in both cases and we can remove the edge
              removeEdges++; 
           }
         }
         else if(a[0]==1){
             boolean alice=union(a[1],a[2],aparent,arank);
             if(alice==true){//i.e merging is happing btw the 2 elements
             amerged++;  
           }
           if(alice==false){//i.e merging is not happing btw the 2 elements  and we can remove the edge
               removeEdges++;
           }
         }
         else{//a[0]==2
          boolean bob=union(a[1],a[2],bparent,brank);
            if(bob==true){//i.e merging is happing btw the 2 elements
             bmerged++;  
           }
           if(bob==false){//i.e merging is not happing btw the 2 elements  and we can remove the edge
               removeEdges++;
           }  
         }
     }
     
     if(amerged !=n || bmerged !=n){
         return -1;
         
     }
     
     return removeEdges;
    }
    
      public boolean union(int x,int y,int [] parent,int [] rank){
      int lx=find(x,parent);
      int ly=find(y,parent);
      
      if(lx!=ly){
          if(rank[lx]>rank[ly]){
              parent[ly]=lx;
          }
          else if(rank[lx]<rank[ly]){
              parent[lx]=ly;
          }
          else{
              parent[lx]=ly;
              rank[ly]++;
          }
          
          return true;//i.e merging of 2 elements are occuring 
      }
      
      return false;//i.e merging of 2 elements are not  occuring 
  }
  public  int find(int x ,int [] parent){
      if(parent[x]==x){
          return x;
      }
      
      int temp=find(parent[x],parent);
      parent[x]=temp;
      
      return temp;
      
  }
}