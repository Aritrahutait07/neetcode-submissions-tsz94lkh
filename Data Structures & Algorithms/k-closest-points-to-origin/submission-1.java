class Solution {
    PriorityQueue<int[]> pq =  new PriorityQueue<>((a,b)->distance(b)-distance(a));
    public int[][] kClosest(int[][] points, int k) {
        for(int[] p:points){
            pq.add(p);
            while(pq.size()>k){
                pq.poll();
            }
        }
        int[][] res = new int[k][2];
        int i =0;
        while(pq.size()!=0){
            
            res[i]=pq.poll();
            i++;
        }
        return res;


    }
    private int distance(int[] p){
        return p[0]*p[0]+p[1]*p[1];
    }
}
