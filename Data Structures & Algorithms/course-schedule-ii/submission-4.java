class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] c:prerequisites){
            indegree[c[0]]++;
            adj.get(c[1]).add(c[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                // if(adj.get(i)==null){
                //     res.add(i);
                // }else{
                //     q.add(i);
                // }
                q.add(i);
                
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            res.add(curr);
            for(int n:adj.get(curr)){
                indegree[n]--;
                if(indegree[n]==0){
                    q.add(n);
                }
            }

        }
        int[] p = new int[numCourses];
        int s = 0;

        if(res.size()!=numCourses){
            
            return new int[0];
        }else{
            for(int i:res){
                p[s] = i;
                s++;
            }
        }
        return p;
    }
}
