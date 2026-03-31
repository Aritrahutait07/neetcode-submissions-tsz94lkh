class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int sum = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(dfs(i,j,grid,visited,row,col)){
                    sum +=1;
                }
            }
        }
        return sum;

    }

    public boolean dfs(int r,int c,char[][] grid,boolean[][] visited,int row,int col){
        if (r < 0 || c < 0 || r >= row || c >= col
            || visited[r][c]
            || grid[r][c] == '0') {
            return false;
        }

        visited[r][c]=true;
        dfs(r+1,c,grid,visited,row,col);
        dfs(r-1,c,grid,visited,row,col);
        dfs(r,c+1,grid,visited,row,col);
        dfs(r,c-1,grid,visited,row,col);

        return true;
    }
}
