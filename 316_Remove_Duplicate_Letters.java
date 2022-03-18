/*
316. Remove Duplicate Letters
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:
Input: s = "bcabc"
Output: "abc"

Example 2:
Input: s = "cbacdcbc"
Output: "acdb"
 
Constraints:
1 <= s.length <= 10^4
s consists of lowercase English letters.

Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
*/
class Solution {
    public String removeDuplicateLetters(String s) {
      int[] lastIndex=new int[26];
        for(int i=0;i<s.length();i++){
            lastIndex[s.charAt(i)-'a']=i;
        }
        boolean[] seen=new boolean[26];
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            int c=s.charAt(i)-'a';
            if(seen[c]) continue;
            
            while(!st.isEmpty() && st.peek()>c && i<lastIndex[st.peek()])
            seen[st.pop()]=false;
            
            st.push(c);
            seen[c]=true;
        }
        
        StringBuilder res=new StringBuilder();
        while(!st.isEmpty()){
            
            res.append((char) (st.pop()+'a'));
        }
       return res.reverse().toString();  
    }
}
