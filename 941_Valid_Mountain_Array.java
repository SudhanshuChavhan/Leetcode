/*
941. Valid Mountain Array
Given an array of integers arr, return true if and only if it is a valid mountain array.
Recall that arr is a mountain array if and only if:
arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Example 1:
Input: arr = [2,1]
Output: false

Example 2:
Input: arr = [3,5,5]
Output: false

Example 3:
Input: arr = [0,3,2,1]
Output: true

Constraints:
1 <= arr.length <= 104
0 <= arr[i] <= 10^4
*/
class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        boolean ascend= true;
        int i,max = arr[0];
        for(i=1; i<arr.length; i++){
            if(max==arr[i]) return false;
            else if (max<arr[i]) max = arr[i];
            else {
                ascend = false;
                break;
            }
        }
        if(i==1 || ascend) return false;
        int min=arr[i++];
        for ( ; i<arr.length; i++){
            if(arr[i]==min) return false;
            else if(min > arr[i]) min=arr[i];
            else return false;
        }
        return true;
    }
}
