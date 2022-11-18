class Solution {
    public int orangesRotting(int[][] grid) {
         Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int time = 0;
        int freshCount = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 2){
                    queue.add(new int[]{i, j}); 
                }
                if (grid[i][j] == 1){
                    freshCount++;
                }
            }
        }

        while (!queue.isEmpty() && freshCount > 0){
            time++;
            int size = queue.size();

            for (int i = 0; i < size; i++){
                int[] pos = queue.poll(); 
                for (int[] d : directions){
                    int x = pos[0] + d[0];
                    int y = pos[1] + d[1];
                    if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != 1){
                        continue;
                    }else {
                        grid[x][y] = 2; 
                        queue.add(new int[]{x, y}); 
                        freshCount--;
                    }
                }
            }
        }

        return freshCount == 0 ? time : -1;
    }
}