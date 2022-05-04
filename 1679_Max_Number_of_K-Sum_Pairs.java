/*
1679. Max Number of K-Sum Pairs
You are given an integer array nums and an integer k.
In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.
Return the maximum number of operations you can perform on the array.

Example 1:
Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.

Example 2:
Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
 
Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= 109
*/
import java.util.HashMap;
class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap <Integer, Integer> map = new HashMap<Integer, Integer>();
        int count, ans=0;
        for(int i: nums){
            if(i<k){
                //map it
                if(map.containsKey(i) == false)
                    count=0;
                else
                    count = map.get(i);
                map.put(i, count+1);
            }
        }
        int j=1;
        for(Integer key: map.keySet()){
            if(j <= k/2){
                int i=key.intValue();
                if(map.containsKey(i) && map.containsKey(k-i) ){
                    if(i == k-i){
                        int val = map.get(i).intValue();
                        ans+= val/2;
                        map.put(i,val-val/2);
                    }
                    else{
                        int first = map.get(i).intValue(), 
                            second = map.get(k-i).intValue(),
                            small = first < second? first: second;
                        ans+=small;
                        map.put(i,first-small);
                        map.put(k-i,second-small);
                    }
                    j++;
                }
            }
            else
                break;
        }       
        return ans;
    }
}
