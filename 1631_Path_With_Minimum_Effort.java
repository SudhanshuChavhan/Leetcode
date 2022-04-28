/*
1631. Path With Minimum Effort
You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

Example 1:
Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
Output: 2
Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

Example 2:
Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
Output: 1
Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells, which is better than route [1,3,5,3,5].

Example 3:
Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
Output: 0
Explanation: This route does not require any effort.
 
Constraints:
rows == heights.length
columns == heights[i].length
1 <= rows, columns <= 100
1 <= heights[i][j] <= 10^6
*/
class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int n=heights.length;
        int m=heights[0].length;
        
        if(n==1 && m==1)
            return 0;
        
        int efforts[][]=new int[n][m];//stores the minimum effots required to travel upto a given cell
        for(int row[]:efforts)
            Arrays.fill(row,Integer.MAX_VALUE);
        
        PriorityQueue<int[]>pq=new PriorityQueue<int[]>((t1,t2)->(t1[2]-t2[2]));//returns cell with minimum efforts
        
        pq.offer(new int[]{0,0,0});
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};//direction to travel
        
        while(!pq.isEmpty())
        {
            int curr[]=pq.poll();
            int curr_row=curr[0];
            int curr_col=curr[1];
            int curr_wt=curr[2];
            for(int x[]:dir)
            {
                int nrow=curr_row+x[0];
                int ncol=curr_col+x[1];
                if(nrow<0 || nrow>=n || ncol<0 || ncol>=m)
                    continue;
                int wt = Math.max(curr_wt,Math.abs(heights[nrow][ncol]-heights[curr_row][curr_col]));//getting max absolute value
                //updating the minimum effort
                if(wt<efforts[nrow][ncol])
                {
                    efforts[nrow][ncol]=wt;
                    pq.offer(new int[]{nrow,ncol,wt});
                }
                
            }
        }
        return efforts[n-1][m-1];
    }
}
