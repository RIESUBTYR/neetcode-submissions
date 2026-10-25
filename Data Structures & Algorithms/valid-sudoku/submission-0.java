class Solution {
    public boolean isValidSudoku(char[][] board) {

        if(board.length != 9 || board[0].length!=9){
            return false;
        }

        for(int i=0;i<board.length;i++){
            char[] column = {board[0][i],board[1][i],board[2][i],board[3][i],board[4][i],board[5][i],board[6][i],board[7][i],board[8][i]};
            System.out.println("Row and Column Checking...."+i);
            System.out.println(Arrays.toString(board[i]));
            System.out.println(Arrays.toString(column));
            if(!rowValid(board[i]) || !rowValid(column)) return false;
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                char[] grid = {board[i*3][j*3],board[i*3][j*3+1],board[i*3][j*3+2],board[i*3+1][j*3],board[i*3+1][j*3+1],board[i*3+1][j*3+2],board[i*3+2][j*3],board[i*3+2][j*3+1],board[i*3+2][j*3+2]};
                System.out.println("Grid Checking...."+i);
                System.out.println(Arrays.toString(grid));
                if(!rowValid(grid)) return false;
            }
        }

        return true;
    }

    public boolean rowValid(char[] row){
        Map<Character,Boolean> visited = new HashMap<Character,Boolean>();

        for(int i=0;i<row.length;i++){
            if(row[i]!='.')
            {
            if(visited.getOrDefault(row[i],false)){
                return false;
            }
            else{
                visited.put(row[i],true);
            }
            }
        }

        return true;
    }

}
