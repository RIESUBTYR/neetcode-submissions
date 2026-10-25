class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n = nums1.length;
        int m = nums2.length;
        
        

        if(m<n){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        

        n = nums1.length;
        m = nums2.length;

        int begin =0;
        int end = n;
        int half = (n+m+1)/2;

        while(begin<=end){
            int mid = (begin+end)/2;
            int opp_mid = half-mid;
            
            int num1Left = mid > 0 ? nums1[mid-1]: Integer.MIN_VALUE;
            int num1Right = mid < n ? nums1[mid] : Integer.MAX_VALUE;
            int num2Left = opp_mid > 0 ? nums2[opp_mid-1]: Integer.MIN_VALUE;
            int num2Right = opp_mid < m ? nums2[opp_mid] : Integer.MAX_VALUE;


            if(num1Left <= num2Right && num2Left <= num1Right){
                if((n+m)%2 != 0){
                    return Math.max(num1Left,num2Left);
                }
                return (Math.max(num1Left,num2Left) + Math.min(num1Right,num2Right)) / 2.0;
            }
            else if(num1Left>num2Right){
                end = mid-1;
            }
            else{
                begin = mid+1;
            }
        }

        return -1;
    }
}
