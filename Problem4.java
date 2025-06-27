// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

public class Problem4 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null && curB != null) {
            curA = curA.next;
            curB = curB.next;
        }
        while (curB != null) {
            curB = curB.next;
            headB = headB.next;
        }
        while (curA != null) {
            curA = curA.next;
            headA = headA.next;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
