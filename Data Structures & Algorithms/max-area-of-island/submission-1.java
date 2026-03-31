class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {

                    //int area = 0;
                           // found a new island
                    int area = bfs(grid, i, j);
                    if(area>maxArea){
                        maxArea = area;
                    }  // mark the whole island
                }
            }
        }
        return maxArea;
        
    }
    private int bfs(int[][] grid, int i, int j) {
        int area = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        grid[i][j] = 0;  // mark visited

        int[][] directions = {
            {1, 0},   // down
            {-1, 0},  // up
            {0, 1},   // right
            {0, -1}   // left
        };

        while (!queue.isEmpty()) {
            area++;
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for (int[] d : directions) {
                
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && ny >= 0 &&
                    nx < rows && ny < cols &&
                    grid[nx][ny] == 1) {
                    //area++;
                    grid[nx][ny] = 0;  // mark visited
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return area;
    }
    

    
}
