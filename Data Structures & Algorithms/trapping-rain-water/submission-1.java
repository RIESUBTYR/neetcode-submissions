class Solution {
    public int trap(int[] height) {
        int n= height.length;
        int left[] =new int[n];
        int right[] = new int[n];
        left[0]=0;
        right[n-1]=0;
        int maxL=0;
        int maxR=0;
        for(int i=1;i<n;i++){
            left[i] = Math.max(maxL,height[i-1]);
            maxL=Math.max(maxL,height[i-1]);
            right[n-i-1]= Math.max(maxR,height[n-i]);
            maxR=Math.max(maxR,height[n-i]);
        }

        int water=0;
        for(int i=0;i<n;i++){
            int minHeight= Math.min(left[i],right[i]);

            if(minHeight>height[i])
            {
                water += minHeight-height[i];
            }
        }
        return water;
    }
}
