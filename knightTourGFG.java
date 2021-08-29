import java.util.*;

public class knightTourGFG {

    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[][] board = new int[n][n];

        int[][] dir = {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

        initialBoard(board);
        boolean ans = knightTour(0, 0, 0, dir, board);
        // for(int i = 0; i < n; i++)
        // {
        //     for(int j = 0; j < n; j++)
        //     {
        //         System.out.print(board[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        printBoard(board);
    }

    public static void printBoard(int[][] board)
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void initialBoard(int[][] board)
    {
        for(int i = 0; i < board.length; i++)
        for(int j = 0; j < board[0].length; j++)
        board[i][j] = -1;

    }
    public static boolean knightTour(int sr, int sc, int move, int[][] dir, int[][] board)
    {

        board[sr][sc] = move;

        int n = board.length;
        if(move == (n*n)-1)
        {
            return true;
        }

        boolean ans = false;

        for(int d = 0; d < dir.length; d++)
        {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r >= 0 && c >= 0 && r < board.length && c < board[0].length && board[r][c] == -1)
            {
                ans = ans || knightTour(r, c, move + 1, dir, board);
                if(ans)
                {
                    return true;
                }
            }
            
        }
        board[sr][sc] = -1;
        return ans;
    }   
}