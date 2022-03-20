/*
1007. Minimum Domino Rotations For Equal Row
In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.
If it cannot be done, return -1.

Example 1:
Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

Example 2:
Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.
 
Constraints:
2 <= tops.length <= 2 * 10^4
bottoms.length == tops.length
1 <= tops[i], bottoms[i] <= 6
*/
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int num1 = tops[0];
        int num2 = bottoms[0];
		//no. of times num1 or num2 needed to swap
        int c1 = checkCount(num1,tops,bottoms);
        int c2 = checkCount(num1,bottoms,tops);
        int c3 = checkCount(num2,tops,bottoms);
        int c4 = checkCount(num2,bottoms,tops);
        int res = Math.min(Math.min(c1,c2),Math.min(c3,c4));
        return res==Integer.MAX_VALUE?-1:res;
    }
    int checkCount(int num1,int[] tops,int[] bottoms){
        int count=0;
        for(int i=0;i<tops.length; i++){
            if(num1==tops[i]){
                //count++;
            }else if(num1==bottoms[i]){
                count++;
            }else{
                count=Integer.MAX_VALUE;
                return count;
            }
        }
        return count;
    }
}
