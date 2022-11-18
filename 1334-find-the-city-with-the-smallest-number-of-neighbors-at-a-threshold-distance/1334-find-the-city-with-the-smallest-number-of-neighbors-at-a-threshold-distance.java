class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] D= new int[n][n];
        
        for (int[] row:D){
             Arrays.fill(row, Integer.MAX_VALUE);
        }   
        for (int[] edge:edges)
        {  
            int from= edge[0];
            int to= edge[1];
            int wt= edge[2];
            D[from][to]= wt;
            D[to][from]= wt;
        }      
         for(int k=0;k<n;k++){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               
                    if(D[i][k]==Integer.MAX_VALUE || D[k][j]==Integer.MAX_VALUE)
                        continue;
                    else if((D[i][k]+D[k][j])<D[i][j])
                        D[i][j]=D[i][k]+D[k][j];
                }
            }
         }
        int minNoOfCity= Integer.MAX_VALUE;
        int res= -1;
        for(int i=0;i<n;i++)
        {
            int noCityCount= 0;
            for(int j=0;j<n;j++)
            {
               if(i==j)
                    continue;
               if(D[i][j]<=distanceThreshold)
                   noCityCount+= 1;
            }
            if (noCityCount <= minNoOfCity ){
                minNoOfCity= noCityCount;
                res= i;
            }
        }
        return res;
    }
}