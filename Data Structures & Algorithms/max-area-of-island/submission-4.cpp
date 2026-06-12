class Solution {
    int row, col;
public:
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        if (grid.empty()) return 0;
        row = grid.size();
        col = grid[0].size();
        int MAX_AREA = 0;
        int result = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    int area = dfs(grid,i,j);
                    if(MAX_AREA<area){
                        MAX_AREA = area;
                    }
                }
                
            }
        }
        return MAX_AREA ;
    }
    int dfs(vector<vector<int>>& grid,int r,int c){
        if(r>=row || r<0 || c>=col || c<0 || grid[r][c]==0){
            return 0;
        }
        grid[r][c] = 0 ;
        int currSize = 1;
        currSize += dfs(grid,r+1,c);
        currSize += dfs(grid,r-1,c);
        currSize += dfs(grid,r,c+1);
        currSize += dfs(grid,r,c-1);
        return currSize;
     }
};
