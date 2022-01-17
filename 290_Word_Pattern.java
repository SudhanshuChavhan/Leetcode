/*
290. Word Pattern
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true

Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false

Example 3:
Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false

Constraints:
1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
*/
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[] = s.split(" ");
        
        if(words.length != pattern.length()) return false; // base condition, if words length not equals to pattern length
        // eg :- aaa != aa aa aa aa
        
        Map<Character, String> map1 = new HashMap<>(); // this hashmap assign the characters with words
        Map<String, Boolean> map2 = new HashMap<>(); // in this map we will mark the words as used
        
        for(int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            
            if(map1.containsKey(ch) == false){ // if the pattern character has not been mapped
                if(map2.containsKey(words[i]) == true){ // but the word which we will assign to i character has been used
                    return false; // eg :- dog = a & now dog = b;
                }
                else{ // if the word has not been used;
                    map2.put(words[i], true); // now mark it as used
                    map1.put(ch, words[i]); // and put that word infront of character
                }
            }
            else{ 
                // if that character has already been mapped, now check with whom it has been mapped
                String mwith = map1.get(ch);
                // if mwith word is not equals to words[i], means already mapped with someone, then return false; 
                // eg :- a = dog & now a = cat
                if(mwith.equals(words[i]) == false) return false;
            }
        }
        return true;
    }
}
