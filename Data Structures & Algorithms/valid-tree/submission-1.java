class Solution {
    public boolean validTree(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        int edge = 0;
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            edge++;
        }
        boolean[] visited = new boolean[n];
        for(int[] e:edges){
            adj.get(e[1]).add(e[0]);
            adj.get(e[0]).add(e[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0]=true;
        int count = 1;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int s:adj.get(curr)){
                if(!visited[s]){
                    q.add(s);
                    visited[s]=true;
                    count++;
                }
            }

        }
        if(edge==n-1 && count==n){
            return true;
        }else{
            return false;
        }
    }
}
