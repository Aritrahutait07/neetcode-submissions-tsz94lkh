class Solution {
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=0;i<n+1;i++){
            parent[i] = i;
            rank[i] = 1;
        } 
        int[] ans = new int[2];

        for(int[] e : edges){
            if(union(e[0], e[1])){
                ans[0] = e[0];
                ans[1] = e[1];
            }
        }

        return ans;
     

    }
    private int findParent(int x){
        if(parent[x]==x){
            return x;
        }else{
            return findParent(parent[x]);
        }
    }
    private boolean union(int x,int y){
        int xp = findParent(x);
        int yp = findParent(y);
        if(xp==yp) return true;

        if(rank[xp]>rank[yp]){
            parent[yp]=xp;
        }else if(rank[xp]<rank[yp]){
            parent[xp]=yp;
        }else{
            parent[xp]=yp;
            rank[yp]++;
        }

        return false;
    }
}
