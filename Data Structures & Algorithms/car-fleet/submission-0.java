class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        double[][] cars = new double[n][2];
        for(int i=0;i<n;i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars,(a,b) -> Double.compare(b[0],a[0]));
        int count=0;
        double[] timeToReach = new double[n];
        for(int i=0;i<n;i++){
            timeToReach[i] = (target-cars[i][0])/cars[i][1];
            if(i>=1 && timeToReach[i]<=timeToReach[i-1]){
                timeToReach[i] = timeToReach[i-1];
            } else{
                count++;
            }
        }
        return count;
    }
}
