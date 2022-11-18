class Solution {
    int count;
    public int totalNQueens(int n) {
        count=0;
        boolean[][] visited=new boolean[n][n];
         QueenCount(visited,0);
        return count;
    }
    public void QueenCount(boolean visited[][],int row){
        if(visited.length==row){
            count++;
            return;
        }
        //int count=0;
        for(int col=0;col<visited.length;col++){
            if(isValid(visited,row,col)){
                visited[row][col]=true;
                QueenCount(visited,row+1);
                visited[row][col]=false;
            }
        }
        return;
    }
    
    public boolean isValid(boolean visited[][],int row,int col){
    // Vertical row
    for(int i=0;i<row;i++){
        if(visited[i][col])
            return false;
    }
    
    // Left diagonal
    int maxLeft = Math.min(row,col);
    for(int i=1;i<=maxLeft;i++){
        if(visited[row-i][col-i]){
            return false;
        }
    }
    
    // Right diagonal
    int maxRight = Math.min(row,visited.length-col-1);
    for(int i=1;i<=maxRight;i++){
        if(visited[row-i][col+i]){
            return false;
        }
    }
    return true;
    }
}