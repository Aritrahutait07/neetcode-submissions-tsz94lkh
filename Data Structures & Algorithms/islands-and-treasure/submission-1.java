

class Solution {

    private static final int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // 1. Add all treasures to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Directions: right, left, down, up
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

        // 2. Multi-source BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];

                // Boundary check
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                // Only update land cells that are INF
                if (grid[nx][ny] == INF) {
                    grid[nx][ny] = grid[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}

