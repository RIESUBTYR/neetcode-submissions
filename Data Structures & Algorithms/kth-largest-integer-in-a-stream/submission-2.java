class KthLargest {

    ArrayList<Integer> heap;
    int ksize;

    public KthLargest(int k, int[] nums) {
        heap = new ArrayList(k);
        ksize=k;
        for(int num:nums){
            add(num);
        }
        
    }
    
    public int add(int val) {
        heap.add(val);

        int index = heap.size()-1;

        while(index>0 && heap.get((index-1)/2) > heap.get(index) ){
            int tmp = heap.get(index);
            heap.set(index,heap.get((index-1)/2));
            heap.set((index-1)/2, tmp);
            index= (index-1)/2;
        }

        if( ksize < heap.size()){
        index = 0;
        heap.set(index, heap.get(heap.size() - 1));

        // Remove the last element
        heap.remove(heap.size() - 1);

        // Heapify the tree starting from the element at the
        // deleted index
        while (true) {
            int left_child = 2 * index + 1;
            int right_child = 2 * index + 2;
            int smallest = index;

            if (left_child < heap.size() && heap.get(left_child) < heap.get(smallest)) {
                smallest = left_child;
            }
            if (right_child < heap.size() && heap.get(right_child) < heap.get(smallest)) {
                smallest = right_child;
            }
            if (smallest != index) {
                int temp = heap.get(index);
                heap.set(index, heap.get(smallest));
                heap.set(smallest, temp);
                index = smallest;
            } else {
                break;
            }
        }
        }
        return heap.get(0);
    }
}
