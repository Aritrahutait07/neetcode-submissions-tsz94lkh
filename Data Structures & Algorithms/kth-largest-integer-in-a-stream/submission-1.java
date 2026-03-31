class KthLargest {
    private PriorityQueue<Integer> pq =  new PriorityQueue<>();
    int k;
    public KthLargest(int k, int[] nums) {
       for(int n:nums){
        pq.add(n);
       }
       this.k = k;
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }
}
