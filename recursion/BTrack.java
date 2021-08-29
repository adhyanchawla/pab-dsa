import java.util.*;

public class BTrack {
    

    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int [][]maze = new int[n][n];

        // for(int i = 0; i < n; i++)
        // {
        //     for(int j = 0; j < n; j++)
        //     {
        //         maze[i][j] = scn.nextInt();
        //     }
        // }
        
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        System.out.println(longestPathLength(maze, dir, 0, 0));

        //printBoard(maze);
    }

    public static int mazePath(int[][]board, int[][] maze, String[]path, String psf, int sr, int sc, int dr, int dc)
    {
        if(sr == dr && sc == dc)
        {
            System.out.println(psf);
            return 1;
        }
        int count = 0;
        board[sr][sc] = 1;

        for(int i = 0; i < maze.length; i++)
        {
            for(int jump = 1; jump < Math.max(board.length, board[0].length); jump++)
            {
                int r = sr + jump*maze[i][0];
                int c = sc + jump*maze[i][1];

                if(r >= 0 && c >= 0 && r <= dr && c <= dc)
                {
                    if(board[r][c] == 0)
                    count += mazePath(board, maze, path, psf + path[i] + jump, r, c, dr, dc);
                }
                else break;
            }
        }

        board[sr][sc] = 0;
        return count;
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

    public static boolean knightTour(int[][] board, int[][] dir, int sr, int sc, int move)
    {
        int n = board.length;
        board[sr][sc] = move;
        if(move == (n*n)-1)
        {
            //printBoard(board);  
            return true;   
        }
        //move += 1;
        
        boolean ans = false;

        for(int i = 0; i < dir.length; i++)
        {
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];

            if(r >= 0 && c >= 0 && r < board.length && c < board.length && board[r][c] == -1)
            {
                
                ans = knightTour(board, dir, r, c, move + 1);
                if(ans)
                return true;
                
            }
        }

        board[sr][sc] = -1;
        return ans;
    }

    public static int longestPathLength(int[][] maze, int[][] dir, int sr, int sc)
    {
        if(sr == maze.length-1 && sc == maze[0].length-1)
        {
            return 0;
        }

        //int lpath = -1;
        int maxPath = -1; //point to same variable
        maze[sr][sc] = 1;
        for(int i = 0; i < dir.length; i++)
        {
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];

            if(r >= 0 && c >= 0 && r <= maze.length-1 && c <= maze[0].length-1 && maze[r][c] == 0)
            {
                int lpath = longestPathLength(maze, dir, r, c);
                if(lpath != -1 && lpath + 1 > maxPath) //point to same variable
                {
                    maxPath = lpath + 1;
                }
            }
        }
        maze[sr][sc] = 0;
        return maxPath;
   }

   public static int smallestPathLength(int[][] maze, int[][] dir, int sr, int sc)
    {
        if(sr == maze.length-1 && sc == maze[0].length-1)
        {
            return 0;
        }

        //int spath = -1;
        int minPath = (int)1e9;
        maze[sr][sc] = 1;
        for(int i = 0; i < dir.length; i++)
        {
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];

            if(r >= 0 && c >= 0 && r <= maze.length-1 && c <= maze[0].length-1 && maze[r][c] == 0)
            {
                int spath = smallestPathLength(maze, dir, r, c);
                if(spath != (int)1e9 && spath + 1 < minPath)
                {
                    //dont return here as there can be other smaller paths as well
                    minPath = spath + 1;
                }
            }
        }
        maze[sr][sc] = 0;
        return minPath;
   }
}