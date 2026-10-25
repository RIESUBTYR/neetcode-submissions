class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=-1;
        int n = piles.length;
        for(int i=0;i<n;i++){
            max = Math.max(piles[i],max);
        }

        if(piles.length==h){
            return max;
        }

        int begin =1;
        int end = max;
        int mid = 0;
        int res=h;
        int answer=0;
        while(begin<=end)
        {
            mid = (begin+end)/2;
            int temph=0;
            
            for(int i = 0; i<n;i++)
            {
                temph+= Math.ceil((double)piles[i]/mid);
            }

            if(temph<=h){
                end = mid-1;
                answer = mid;
            }
            else{
                begin = mid+1;
            }
        }

        return answer;
    }
}
