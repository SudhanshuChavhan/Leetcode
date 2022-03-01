/*
338. Counting Bits
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

Example 1:
Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10

Example 2:
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

Constraints:
0 <= n <= 10^5

Follow up:
It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
*/
class Solution {
    public int[] countBits(int n) {
        int res[] = new int[n + 1]; 
        
        for(int i = 0; i <= n; i++){ 
            res[i] = solve(i, res);
        }
        return res;
    }
    public int solve(int n, int memo[]){

        if(n == 0) return 0;
        if(n == 1) return 1;
        
        if(memo[n] != 0) return memo[n]; // if memo of n answer is already available we will re-use it & not go further for calculation
        // but if you are coming for the first time then, store that value in memo
        if(n % 2 == 0) {
            memo[n] = solve(n / 2, memo);
            return solve(n / 2, memo);
        }
        else {
            memo[n] = 1 + solve(n / 2, memo);
            return 1 + solve(n / 2, memo);
        } 
    }
}
