public class Board{
    private static int row;
    private static int col;
    private int[][] board;

    public Board(){
        row = 6;
        col = 7;
        board = new int[row][col];
    }

    public Board(int rows, int columns){
        row = rows;
        col = columns;
        board = new int[row][col];
    }

    public void addPiece(int row, int col, boolean player){
        if(player){
            board[row][col] = 1;
        }else{
            board[row][col] = 2;
        }
    }

    public boolean isValid(int row, int col){
        if(row != board.length-1){
            for(int i=row+1; i<board.length; i++){
                if(board[i][col] == 0)
                    return false;
            }
        }
        if(board[row][col] != 0){
            return false;
        }

        return true;
    }

    public boolean checkWin(){
        //horizontal win
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length - 3; j++){
                if(board[i][j] != 0 && board[i][j] == board[i][j+1] && board[i][j] == board[i][j+2] && board[i][j] == board[i][j+3]){
                    return true;
                }
            }
        }

        //vertical win
        for(int i=0; i<board.length - 3; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] != 0 && board[i][j] == board[i+1][j] && board[i][j] == board[i+2][j] && board[i][j] == board[i+3][j]){
                    return true;
                }
            }
        }

        //diagnol win topleft to bottomright
        for(int i=0; i<board.length - 3; i++){
            for(int j=0; j<board[0].length - 3; j++){
                if(board[i][j] != 0 && board[i][j] == board[i+1][j+1] && board[i][j] == board[i+2][j+2] && board[i][j] == board[i+3][j+3]){
                    return true;
                }
            }
        }

        //diagnol win bottomleft to topright
        for(int i=3; i<board.length; i++){
            for(int j=0; j<board[0].length - 3; j++){
                if(board[i][j] != 0 && board[i][j] == board[i-1][j+1] && board[i][j] == board[i-2][j+2] && board[i][j] == board[i-3][j+3]){
                    return true;
                }
            }
        }

        return false;
    }
    
}