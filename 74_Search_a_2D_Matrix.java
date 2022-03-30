/*
74. Search a 2D Matrix
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 
Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false
 
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-10^4 <= matrix[i][j], target <= 10^4
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean present=false; 
        int i, len = matrix[0].length;
        
        for(i=0; i<matrix.length; i++){
            if(target <= matrix[i][len-1]){
                present = true;
                if(target == matrix[i][len-1])
                    return true;
                break;
            }
        }
        if(present == false)
            return false;
        
        //binary search
        int mid, start = 0, end = len-1;
        while(end >= start){
            mid = (start+end)/2;
            if(matrix[i][mid] == target)
                return true;
            else if(matrix[i][mid] > target)
                end = mid-1;
            else
                start = mid+1;
        }
        return false;
    }
}
