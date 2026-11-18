class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); 

        for(int stone:stones){
            maxHeap.offer(stone);
        }
        while(maxHeap.size()>1){
            int x = maxHeap.poll();
            int y = maxHeap.poll();

            if(x == y) continue;
            else maxHeap.offer(Math.abs(x-y));
        }

        if(maxHeap.isEmpty()){
            return 0;
        }

        return maxHeap.poll();
    }
}
