class Solution {
    public int lastStoneWeight(int[] stones) {
        // MAX Heap
        PriorityQueue<Integer> pq =  new PriorityQueue<>(Collections.reverseOrder());
        // Initialize MAX Heap
        for(int stone:stones){
            pq.add(stone);
        }
        int newWeight;
        
        while(pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();
            

            if(x==y){
                newWeight = 0;
            }if(y>x){
                newWeight = y-x;
            }else{
                newWeight = x-y;
            }

            pq.add(newWeight);
        }

        return pq.isEmpty() ? 0: pq.peek();



    }
}
