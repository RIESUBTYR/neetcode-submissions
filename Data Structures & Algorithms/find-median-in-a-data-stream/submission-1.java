class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
        left = new PriorityQueue<Integer>((a,b) -> Integer.compare(b,a));
        right = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        System.out.println(num);
        if(right.isEmpty()){
            right.offer(num);

            return;
        }

        int min = right.peek();

        if(num>min){
            right.offer(num);
        }else{
            left.offer(num);
        }

        if(Math.abs(right.size()-left.size())>1)
        {
            if(right.size()>left.size()){
                int pop = right.poll();
                left.offer(pop);
            }else{
                int pop = left.poll();
                right.offer(pop);
            }
        }

    }
    
    public double findMedian() {
        int size = left.size()+right.size();
        
        if(size%2==0){
            return (double)(left.peek()+right.peek())/2;
        }else{
            if(right.size()>left.size()){
                return right.peek();
            }
            else{
                return left.peek();
            }
        }
    }
}
