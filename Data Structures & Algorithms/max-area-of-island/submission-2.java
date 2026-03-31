class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];
        int maxArea = 0;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){

                if(grid[i][j] == 1 && !visited[i][j]){
                    int area = dfs(i, j, grid, visited, row, col);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    public int dfs(int r, int c, int[][] grid,
                   boolean[][] visited, int row, int col){

        if (r < 0 || c < 0 || r >= row || c >= col
            || visited[r][c]
            || grid[r][c] == 0) {
            return 0;
        }

        visited[r][c] = true;

        
        int area = 1;

        area += dfs(r+1, c, grid, visited, row, col);
        area += dfs(r-1, c, grid, visited, row, col);
        area += dfs(r, c+1, grid, visited, row, col);
        area += dfs(r, c-1, grid, visited, row, col);

        return area;
    }
}
