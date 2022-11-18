class Solution {
    public int[] findBall(int[][] grid) {
        int result[]=new int[grid[0].length];
         for (int i = 0; i < grid[0].length; i++) {
            result[i]=dfs(grid,0,i);
         }
        return result;
        
    }
    public int dfs(int[][] grid,int row,int col){
       if(row==grid.length){
            return col;
       }
    
        int nextColumn = col + grid[row][col];
        if (nextColumn < 0 || nextColumn > grid[0].length - 1 || grid[row][col] != grid[row][nextColumn])           {
          
            return -1;
        }
        return dfs(grid,row+1,nextColumn);
    }
}