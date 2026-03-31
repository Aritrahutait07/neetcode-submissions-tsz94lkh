class Solution {

    Map<Integer, List<Integer>> graph = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {

        // Condition 1: edge count
        if (edges.length != n - 1) return false;

        // Build graph
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // Condition 2 & 3: DFS for cycle + connectivity
        if (!dfs(0, -1)) return false;

        // Ensure connected
        return visited.size() == n;
    }

    private boolean dfs(int node, int parent) {

        if (visited.contains(node)) return false; // cycle detected

        visited.add(node);

        for (int nei : graph.get(node)) {
            if (nei == parent) continue; // skip parent edge
            if (!dfs(nei, node)) return false;
        }

        return true;
    }
}
