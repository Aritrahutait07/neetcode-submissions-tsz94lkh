class Solution {

    Map<Integer, List<Integer>> premap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> visiting = new HashSet<>();
    List<Integer> order = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Build graph
        for (int i = 0; i < numCourses; i++) {
            premap.put(i, new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            premap.get(p[0]).add(p[1]);
        }

        // DFS for each course
        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course)) {
                return new int[0]; // cycle detected
            }
        }

        // Convert List<Integer> → int[]
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }

        return result;
    }

    public boolean dfs(int course) {

        // Cycle detected
        if (visiting.contains(course)) return false;

        // Already processed
        if (visited.contains(course)) return true;

        visiting.add(course);
        //order.add(course);

        for (int pre : premap.get(course)) {
            if (!dfs(pre)) {
                return false;
            }
        }

        visiting.remove(course);
        visited.add(course);

        // Postorder add
        order.add(course);

        return true;
    }
}
