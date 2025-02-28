import java.util.Scanner;

public class code {
    public static void main(String[] args) {
        char[][] board= new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j]=' ';
            }
        }

        System.out.println("Player 1 get 'X");
        Scanner sc= new Scanner(System.in);
        char player1='X';
        boolean gameOver=false;
        while(!gameOver){
            display(board);
            System.out.println("Player "+player1+" enter row and col: ");
            int row=sc.nextInt();
            int col=sc.nextInt();

            if(board[row][col]==' '){
                board[row][col]=player1;
                gameOver=haveOwn(board,player1);
                if(gameOver){
                    System.out.println("Player "+player1+" won the game.");
                }
                else{
                    if(player1== 'X'){
                        player1 = 'O';
                    }
                    else {
                        player1 ='X';
                    }
                }
            }
            else{
                System.out.println("Invalid move. Try Again!");
            }
        }
        display(board);
    }

    public static boolean haveOwn(char[][] board,char ch){
            //check for rows
        for (int i = 0; i < 3; i++) {
            if(board[i][0] ==ch && board[i][1] ==ch && board[i][2] ==ch){
                return true;
            }
        }

            //check for columns
        for (int i = 0; i < 3; i++) {
            if(board[0][1] ==ch && board[1][i] ==ch && board[2][i] ==ch){
                return true;
            }
        }

            //check for diagonals
        if(board[0][0]==ch && board[1][1]==ch && board[2][2]==ch)
            return true;
        if(board[0][2]==ch && board[1][1]==ch && board[2][0]==ch)
            return true;

        return false;
    }

    public static void display(char[][] board){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]+"|");
            }
            System.out.println();
        }
    }
}
