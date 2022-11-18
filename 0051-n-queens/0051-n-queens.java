class Solution {
  public List<List<String>> solveNQueens(int n) {
    boolean[][] board = new boolean[n][n];
    List<List<String>> answer = new ArrayList<>();
    queens(board,0,answer);
    return answer;
}
void queens(boolean[][] board,int row,List<List<String>> answer){
    
    if(row==board.length){
        List<String> res = insert(board);
        answer.add(res);
        return;
    }
    
    // Placing Queens and Checking for every row and column
    for(int col=0;col<board.length;col++){
        //place queen if Safe
        if(isSafe(board,row,col)){
            board[row][col] = true;
            queens(board,row+1,answer); //Recursive call
            board[row][col] = false;    // Backtrack
        }
    }
}

boolean isSafe(boolean[][] board, int row ,int col){
    
    // Vertical row
    for(int i=0;i<row;i++){
        if(board[i][col])
            return false;
    }
    
    // Left diagonal
    int maxLeft = Math.min(row,col);
    for(int i=1;i<=maxLeft;i++){
        if(board[row-i][col-i]){
            return false;
        }
    }
    
    // Right diagonal
    int maxRight = Math.min(row,board.length-col-1);
    for(int i=1;i<=maxRight;i++){
        if(board[row-i][col+i]){
            return false;
        }
    }
    return true;
}
 
  List<String> insert(boolean[][] board){
      
    List<String> ans = new ArrayList<>();
    for(boolean[] row: board){
        String S = "";
        for(boolean element:row){
            if(element){
                S += "Q";
            }
            else
                S += ".";
        }
        ans.add(S);
    }
      return ans;
}
}
