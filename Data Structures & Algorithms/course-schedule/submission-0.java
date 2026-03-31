class Solution {
    Map<Integer, List<Integer>> premap = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            premap.put(i, new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            premap.get(p[0]).add(p[1]);
        }
        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course)) {
                return false;
            }
        }
        return true;

    }
    public boolean dfs(int course){
        if(visiting.contains(course)) return false;
        if(visited.contains(course)) return true;
        visiting.add(course);
        for(int pre : premap.get(course)){
            if(!dfs(pre)){
                return false;
            }
        }
        visiting.remove(course);
        visited.add(course);
        return true;
    }
}
