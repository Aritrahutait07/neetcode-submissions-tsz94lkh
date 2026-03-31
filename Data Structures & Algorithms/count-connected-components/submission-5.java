class Solution {
    int[] parent;
    int[] rank;
    public int countComponents(int n, int[][] edges) {
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        int components = n;
        
        for (int[] e : edges) {
            if (union(e[0], e[1])) {
                components--;
            }
        }

        return components;
    }
    private int findParent(int x){
        if(x==parent[x]){
            return x;
        }else{
            return findParent(parent[x]);
        }
    }
    private boolean union(int x,int y){
        int xp = findParent(x);
        int yp = findParent(y);

        if(xp==yp) return false;

        if(rank[xp]>rank[yp]){
            parent[yp]=xp;
        }else if(rank[xp]<rank[yp]){
            parent[xp]=yp;
        }else{
            parent[xp]=yp;
            rank[yp]++;
        }
        return true;
        
    }
}
