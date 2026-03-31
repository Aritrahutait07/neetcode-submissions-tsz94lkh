class KthLargest {
    private PriorityQueue<Integer> pq =  new PriorityQueue<>();
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num:nums){
            pq.add(num);
        }
        
    }
    
    public int add(int val) {
        // Add new value
        pq.add(val);

        // Keep element only till thr k
        while(pq.size()>k){
            pq.poll();
        }

        // return k th largest element 
        return pq.peek();

    }
}
