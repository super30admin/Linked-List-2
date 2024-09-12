// Time Complexity : O(n) --> where n is max length out of two linked list 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (160): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode curr = headA;
        
        while (curr != null) {
            curr = curr.next;
            lenA++;
        }
        
        curr = headB;
        while (curr != null) {
            curr = curr.next;
            lenB++;
        }
        
        // reducing the gap in the lengths so that heads are equidistance from intersaction point if any
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }
        
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}