// Time Complexity : O(max(n,m)) , n and m are length of LL
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/* Calculate the length of the LL, move head point of larger one by the difference, so that we have equal number od nodes 
left to be traversed for both
now, iterate from this point till the pointers point to the same node, that pointer is the intersection point
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length1=0;
        int length2=0;
        ListNode curr = headA;
          while(curr.next!=null){
             length1++;
             curr = curr.next;
        }
          curr =  headB;
           while(curr.next!=null){
             length2++;
             curr = curr.next;
        }
        while(length1>length2){
              headA=headA.next;
              length1--;
        }
         while(length2>length1){
              headB=headB.next;
              length2--;
        }
        while(headA!=headB){
            headA=headA.next;
             headB=headB.next;
        }
        return headA;
    }
}
