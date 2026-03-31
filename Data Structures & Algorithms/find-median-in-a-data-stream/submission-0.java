class MedianFinder {
    PriorityQueue<Integer> smallHeap ;
    PriorityQueue<Integer> largeHeap ;

    public MedianFinder() {
       smallHeap = new PriorityQueue<>(Collections.reverseOrder()); 
       largeHeap = new PriorityQueue<>();       
    }
    
    public void addNum(int num) {
        smallHeap.add(num);
        largeHeap.add(smallHeap.poll());
        if(largeHeap.size()>smallHeap.size()){
            smallHeap.add(largeHeap.poll());
        }

    }
    
    public double findMedian() {
        if (smallHeap.size() > largeHeap.size()) {
            return (double) smallHeap.peek();
        }
        return (smallHeap.peek() + largeHeap.peek()) / 2.0;
    }
}
