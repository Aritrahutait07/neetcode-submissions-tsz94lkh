class Solution {
    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        int INF = 2147483647;

        // Add all gates to queue
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 0){
                    q.offer(new int[]{r,c});
                }
            }
        }

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for(int[] d : directions){

                int newR = r + d[0];
                int newC = c + d[1];

                if(newR >= 0 && newC >= 0 && newR < rows && newC < cols 
                   && grid[newR][newC] == INF){

                    grid[newR][newC] = grid[r][c] + 1;
                    q.offer(new int[]{newR,newC});
                }
            }
        }
    }
}