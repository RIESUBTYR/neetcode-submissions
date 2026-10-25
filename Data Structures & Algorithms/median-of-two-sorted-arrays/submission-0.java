class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;
        int o = n+m;
        int[] nums3 = new int[o];
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        while(p3<o){
            System.out.printf(
                "%d,%d\n",p1,p2
            );
            if(p1>=n){
                nums3[p3++] = nums2[p2++];
                continue;
            }
            if(p2>=m){
                nums3[p3++] = nums1[p1++];
                continue;
            }
            if(nums1[p1]<=nums2[p2]){
                nums3[p3++] = nums1[p1++];
            } else{
                nums3[p3++] = nums2[p2++];
            }
        }

        if(o%2 == 0 ){
            return (double) (nums3[o/2]+nums3[(o/2)-1])/2;
        }
        else{
            return (double) (nums3[o/2]);
        }

    }
}
