class Solution {
    private PriorityQueue<Integer> pq =  new PriorityQueue<>(Collections.reverseOrder());
    public int lastStoneWeight(int[] stones) {
        for(int s:stones){
            pq.add(s);
        }
        while(pq.size()>1){
            int x1 = pq.poll();
            int x2 = pq.poll();
            int res;
            if(x1==x2){
                res = 0;
            }else{
                res = Math.abs(x1-x2);
            }
            pq.add(res);
        }
        return pq.isEmpty() ? 0 : pq.peek();
        
    }
}
