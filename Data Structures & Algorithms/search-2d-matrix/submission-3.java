class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int beginrow = 0;
        int endrow = m-1;
        int midrow = 0;
        while(beginrow<=endrow){
            midrow = beginrow+((endrow-beginrow)/2);
            System.out.println(midrow);
            if(target<=matrix[midrow][n-1]){
                if(midrow==0 || target >= matrix[midrow-1][n-1])
                {
                    int begincol = 0;
                    int endcol = n-1;
                    int midcol;
                    while(begincol<=endcol){
                        midcol = begincol+((endcol-begincol)/2);
                        if(target == matrix[midrow][midcol]){
                            return true;
                        }
                        else if(target < matrix[midrow][midcol]){
                            endcol = midcol-1;
                        }
                        else{
                            begincol = midcol+1;
                        }
                    }
                }
                endrow = midrow-1;
            }
            else{
                beginrow = midrow+1;
            }
        }
        return false;
    }
}
