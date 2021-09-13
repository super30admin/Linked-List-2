// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while(p1 != p2) {
            p1 = (p1 != null) ? p1.next : headB;
            p2 = (p2 != null) ? p2.next : headA;
        }
        return p1;
    }
}