
class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;

        // Add rotten oranges to queue
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] == 2){
                    q.offer(new int[]{r,c});
                }
                if(grid[r][c] == 1){
                    fresh++;
                }
            }
        }

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int time = 0;

        while(!q.isEmpty() && fresh > 0){

            int size = q.size();

            for(int i = 0; i < size; i++){

                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[] d : directions){

                    int newR = r + d[0];
                    int newC = c + d[1];

                    if(newR >= 0 && newC >= 0 && newR < rows && newC < cols 
                       && grid[newR][newC] == 1){

                        grid[newR][newC] = 2;
                        fresh--;
                        q.offer(new int[]{newR,newC});
                    }
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}