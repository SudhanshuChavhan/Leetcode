/*
520. Detect Capital
We define the usage of capitals in a word to be right when one of the following cases holds:
All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".

Given a string word, return true if the usage of capitals in it is right.

Example 1:
Input: word = "USA"
Output: true

Example 2:
Input: word = "FlaG"
Output: false

Constraints:
1 <= word.length <= 100
word consists of lowercase and uppercase English letters.
*/
class Solution {
    public boolean detectCapitalUse(String word) {
        int c;
        boolean small=false, capital=false;
        for(int i=0; i<word.length(); i++){
            c = (int)word.charAt(i);
            if( c<= 90 ){
                if(i==0)
                    capital = true;
                else if( small==true && i!= 0)
                    return false;          
            }else{
                if(i == 0 || (capital==true && i==1) ){
                    small = true;
                    capital = false;
                }
                else if(capital==true && i!=1)
                    return false;
            }
        }
        return true;
    }
}
