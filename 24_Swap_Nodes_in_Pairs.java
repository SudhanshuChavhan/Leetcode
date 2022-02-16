/*
24. Swap Nodes in Pairs
Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:
Input: head = [1,2,3,4]
Output: [2,1,4,3]

Example 2:
Input: head = []
Output: []

Example 3:
Input: head = [1]
Output: [1]

Constraints:
The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
*/
class Solution {
    public ListNode swapPairs(ListNode head) {
        
        /**
        * The base condition will be triggered when there is no node left or there is just 1 node.
        * If there is just 1 node left, there is nothing that can be swapped, hence we return the node
        * itself.
        */
        if(head == null || head.next == null) return head;
        
        /**
        * If there are more than 1 nodes remaining, we would recursively call the method by passing the
        * next.next element.
        * This is because we would be swapping the head and the head.next element.
        * So, to call the method we would pass the head.next.next element.
        * This call will return a head which we would have to attach it to the current head.next element,
        AFTER SWAPPING.
        */
        ListNode tHead = swapPairs(head.next.next);
        
        /**
        * Here, we would write the swapping logic.
        * The node which is returned from the above line of code, will be connected with the nodes after
        * swapping here.
        */
        
        ListNode temp = head.next;
        head.next = tHead;
        temp.next = head;
        return temp;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
