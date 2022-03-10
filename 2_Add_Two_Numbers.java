/*
2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 
Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
*/
class Solution {    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
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
/*
//my code :- Memory Limit Exceeded
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
      //  get the digits
      //  add them plus carry
      //  carry forward if present
      //  repeat until any list ends
        
      //  add the carry if present
      //  last.next = (l1.next==null)? l2.next: l1.next;
      //  return head;
        
        ListNode head = new ListNode();
        ListNode last = head;
        int carry=0,sum;
        while(true){
            sum = l1.val + l2.val + carry;
            ListNode node = new ListNode(sum%10);
            carry = sum/10;
            if(head==null)
                head=node;
            else
                last.next = node;
            last = node;
            if(l1.next == null || l2.next==null)
                break;   
        }
        
        last.next = (l1.next==null)? l2.next: l1.next;
        while(carry!=0){
            sum = last.val + carry;
            last.val = sum%10;
            carry = sum/10;
            if(last.next == null && carry==1){
                ListNode newnode = new ListNode(1);
                carry = 0;
                last.next = newnode;
            }
            last = last.next;
        }
        return head;
    }
}
*/
