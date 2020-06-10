class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> minheap ;
    PriorityQueue<Integer> maxheap ;
    
    
    public MedianFinder() {
        minheap = new PriorityQueue<Integer>();
        maxheap = new PriorityQueue<Integer>(new Comparator<Integer>(){
        public int compare(Integer a, Integer b){
            return b-a;
        }
    });
        
    }
    
    public void addNum(int num) {
        PriorityQueue<Integer> selected = (maxheap.size() == 0 || num <= maxheap.peek()) ? maxheap : minheap;
        selected.add(num);
        
        if (Math.abs(maxheap.size() - minheap.size()) >1){
            heapbalance();
        }
        
    }
    
    public double findMedian() {

        if (maxheap.size() == minheap.size()){
            return (double)(maxheap.peek() + minheap.peek())/2;
        }else if(maxheap.size() > minheap.size()){
            return (double)( maxheap.peek());
        }
        return minheap.peek();
    }
    
    public void heapbalance(){
        if (maxheap.size() > minheap.size()){
            int temp = maxheap.poll();
            minheap.add(temp);
        }else{
             int temp = minheap.poll();
            maxheap.add(temp);
        }
        
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */