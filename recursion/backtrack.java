import java.util.*;

public class backtrack{
    public static Scanner scn = new Scanner(System.in);

    public static int mazePaths(int sr, int sc, int[][] maze, int[][] dir, String[] dirS, String ans)
    {
        if(sr == maze.length-1 && sc == maze[0].length-1)
        {
            System.out.println(ans);
            return 1;
        }

        maze[sr][sc] = 1;
        int count = 0;

        for(int d = 0; d < dir.length; d++)
        {
            int r =  sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r >= 0 && c >= 0 && r < maze.length && c < maze[0].length && maze[r][c] == 0)
            {
                count += mazePaths(r, c, maze, dir, dirS, ans + dirS[d]);

            }
        }
        maze[sr][sc] = 0;
        return count;
    }

    public static int mazePathsWithJumps(int sr, int sc, int[][] maze, int[][] dir, String[] dirS, String ans)
    {
        if(sr == maze.length-1 && sc == maze[0].length-1)
        {
            System.out.println(ans);
            return 1;
        }

        maze[sr][sc] = 1;
        int count = 0;
        
        for(int d = 0; d < dir.length; d++)
        {
            for(int rad = 1; rad <= Math.max(maze.length, maze[0].length); rad++){
            int r =  sr + rad*dir[d][0];
            int c = sc + rad*dir[d][1];
            
            if(r >= 0 && c >= 0 && r < maze.length && c < maze[0].length)
            {
                if(maze[r][c] == 0){
                    count += mazePaths(r, c, maze, dir, dirS, ans + dirS[d] + rad);
                }
            }
                else break;
            }
        }
        maze[sr][sc] = 0;
        return count;
    }

    public static int ratInAMaze1(int sr, int sc, int[][] maze, int[][] dir, int[][] soln)
    {
        if(sr == maze.length-1 && sc == maze[0].length-1)
        {
            //printBoard(soln);
            return 1;
        }

        //soln[sr][sc] = 1;
        maze[sr][sc] = 1;
        int count = 0;

        for(int d = 0; d < dir.length; d++)
        {
            int r =  sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r >= 0 && c >= 0 && r < maze.length && c < maze[0].length && soln[r][c] == 1 && maze[r][c] == 0)
            {
                count += ratInAMaze1(r, c, maze, dir, soln);
            }
        }
        maze[sr][sc] = 0;
        return count;
    }

     
    public static boolean ratMazePathWithJumps(int[][] maze, int [][]dir, int sr, int sc, int[][] board)
    {
        board[sr][sc] = 1;
        if(sr == maze.length-1 && sc == maze[0].length-1)
        {
            return true;
        }

        boolean ans = false;
        for(int d = 0; d < dir.length; d++)
        {
            for(int jump = 1; jump <= maze[sr][sc]; jump++)
            {
                int r = sr + jump * dir[d][0];
                int c = sc + jump * dir[d][1];

                if(r >= 0 && c >= 0 && r < maze.length && c < maze[0].length && maze[r][c] > 0)
                {
                   ans = ratMazePathWithJumps(maze, dir, r, c, board);
                   if(ans)
                   {
                       return ans;
                   }
                }
            }
        }

        board[sr][sc] = 0;
        return ans;
    }
   
    public static void main(String[] args)
    {
        // int n = scn.nextInt();
        // int m = scn.nextInt();
        // int[][] maze = new int[n][m];

        // for(int i = 0; i < n; i++)
        // {
        //     for(int j = 0; j < m; j++)
        //     {
        //         maze[i][j] = scn.nextInt();
        //     }
        // }

        //int [][]soln = new int[n][m];
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        String[]dirS = {"t", "l", "d", "r"};
        //boolean ans = shortestPathInMaze(0, 0, maze, dir, dirS, "");
        //System.out.println(ans);
        //int ans = mazePathsWithJumps(0, 0, maze, dir, dirS, "");
        //System.out.println(ans);
        int [][] mazeD = {{2,1,0,0},{3,0,0,1},{0,1,0,1},{0,0,0,1}};
        int[][] dir1 = {{1, 0}, {0, 1}};
        int[][] board = new int[mazeD.length][mazeD[0].length];
        boolean ans = ratMazePathWithJumps(mazeD, dir1, 0, 0, board);
        System.out.println(ans);
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        // //String[]dirS1 = {"t", "l", "d", "r"};
        // int ans1 = ratInAMaze1(0, 0, maze, dir1, soln);

    }
}