import java.util.*;

public class LongestShortest {
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args)
    {
        int n = scn.nextInt();
        int m = scn.nextInt();

        int [][]maze = new int[n][m];

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                maze[i][j] = scn.nextInt();
            }
        }

        int [][]dir = {{-1, 0}, {0, 1}, {1, 0}, {-1, 0}};
        String []dirS = {"T", "R", "D", "L"};

        int ans = shortestPath(maze, 0, 0, dir);
        System.out.println(ans);
        
    }

    public static int longestPath(int[][] maze, int sr, int sc, int[][]dir, String[] dirS, String ans)
    {
        if(sr == maze.length-1 && sc == maze[0].length-1)
        {
            //System.out.println(ans);
            return 0;
        }

        maze[sr][sc] = 1; //mark
        int longestPathLength = -1;
        
        for(int d = 0; d < dir.length; d++)
        {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r >= 0 && c >= 0 && r < maze.length && c < maze[0].length && maze[r][c] == 0)
            {
                int recAns = longestPath(maze, r, c, dir, dirS, ans + dirS[d]);
                if(recAns != -1 && recAns + 1 > longestPathLength)
                {
                    longestPathLength = recAns + 1;
                }
            }
        }
        maze[sr][sc] = 0; //unmark
        return longestPathLength;
    }

    public static int shortestPath(int[][] maze, int sr, int sc, int[][] dir)
    {
        if(sr == maze.length-1 && sc == maze[0].length-1)
        {
            return 0;
        }

        int shortestPathLen = (int)1e9;
        maze[sr][sc] = 1; //mark
        for(int d = 0; d < dir.length; d++)
        {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if(r >= 0 && c >= 0 && r < maze.length && c< maze[0].length && maze[r][c] == 0)
            {
                int recAns = shortestPath(maze, r, c, dir);
                if(recAns != -1 && recAns + 1 < shortestPathLen)
                {
                    shortestPathLen = recAns + 1;
                }
            }
        }
        maze[sr][sc] = 0; //unmark
        return shortestPathLen;
    }
}
