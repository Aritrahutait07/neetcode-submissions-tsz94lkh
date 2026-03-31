class Solution {
    public int islandPerimeter(int[][] grid) {
        int[][] direction =   {{0,1},{0,-1},{-1,0},{1,0}};
        int row = grid.length;
        int col = grid[0].length;
        int param = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    param+=4;
                    for(int[] dir:direction){
                        int newRow = i+dir[0];
                        int newCol = j+dir[1];
                        if(newRow>=0 && newCol>=0 && newCol<col && newRow<row && grid[newRow][newCol]==1){
                            param--;
                        }
                    }
                }
                
            }
        }
        return param;
    }
}