/*
81. Search in Rotated Sorted Array II
There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
You must decrease the overall operation steps as much as possible.

Example 1:
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

Example 2:
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
 
Constraints:
1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
nums is guaranteed to be rotated at some pivot.
-10^4 <= target <= 10^4

Follow up: This problem is similar to Search in Rotated Sorted Array, but nums may contain duplicates. Would this affect the runtime complexity? How and why?
*/
class Solution {
    public boolean search(int[] nums, int target) {
        int i, len = nums.length, end = 0, start = (end+1)%len;
        
        //find start and end point for the sorted array
        for(i = 0; i<len; i++){
            if(nums[end] > nums[start])
                break;
            end = (end+1)%len;
            start = (start+1)%len;
        }
        
        //craete new array
        int arr[] = new int[len];
        i = 0;
        for(int j=start; i<len; i++, j = (j+1)%len){
            arr[i]=nums[j];
            if(j == end)
                break;
        }
        
        //binary search
        start = 0;
        end = len-1;
        while(end >= start){
            i = (start+end)/2;
            if(arr[i] == target)
                return true;
            else if(arr[i] > target)
                end = i-1;
            else
                start = i+1;
        }
        return false;
    }
}
