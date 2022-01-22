/*
1510. Stone Game IV
Alice and Bob take turns playing a game, with Alice starting first.
Initially, there are n stones in a pile. On each player's turn, that player makes a move consisting of removing any non-zero square number of stones in the pile.
Also, if a player cannot make a move, he/she loses the game.
Given a positive integer n, return true if and only if Alice wins the game otherwise return false, assuming both players play optimally.

Example 1:
Input: n = 1
Output: true
Explanation: Alice can remove 1 stone winning the game because Bob doesn't have any moves.

Example 2:
Input: n = 2
Output: false
Explanation: Alice can only remove 1 stone, after that Bob removes the last one winning the game (2 -> 1 -> 0).

Example 3:
Input: n = 4
Output: true
Explanation: n is already a perfect square, Alice can win with one move, removing 4 stones (4 -> 0).
 
Constraints:
1 <= n <= 10^5
*/
class Solution {
    public boolean winnerSquareGame(int n) {
        HashMap<Integer, Boolean> cache = new HashMap<>();
        cache.put(0, false);
        return dfs(cache, n);
    }
    public static boolean dfs(HashMap<Integer, Boolean> cache, int remain) {
        if (cache.containsKey(remain)) {
            return cache.get(remain);
        }
        int sqrt_root = (int) Math.sqrt(remain);
        for (int i = 1; i <= sqrt_root; i++) {
            // if there is any chance to make the opponent lose the game in the next round,
            // then the current player will win.
            if (!dfs(cache, remain - i * i)) {
                cache.put(remain, true);
                return true;
            }
        }
        cache.put(remain, false);
        return false;
    }
}
