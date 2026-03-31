

class Solution {

    public int[][] kClosest(int[][] points, int k) {

        // Max heap based on distance from origin
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> distance(b) - distance(a)
        );

        for (int[] p : points) {
            pq.offer(p);

            // keep only k closest points
            if (pq.size() > k) {
                pq.poll(); // remove farthest
            }
        }

        // build result
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }

    // squared distance (no sqrt needed)
    private int distance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}