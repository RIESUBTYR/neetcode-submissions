class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b) -> Integer.compare(distance(points[a][0],points[a][1]),distance(points[b][0],points[b][1])));

        for(int i=0;i<points.length;i++){
            heap.offer(i);
            
        }

        int[][] res = new int[k][2];
        for(int i=0;i<k;i++){
            int index= heap.poll();
            System.out.println(index);
            
            res[i][0]= points[index][0];
            res[i][1]= points[index][1];
        }

        return res;
    }
    public int distance(int x,int y){
        return x*x + y*y;
    }
}
