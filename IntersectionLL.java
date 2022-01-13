// Time Complexity : O(n) where n is the no of nodes in the list
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

public class IntersectionLL {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode curr = headA;
        // find the length of ListA and List B
        while (curr != null) {
            curr = curr.next;
            lenA++;
        }
        curr = headB;
        while (curr != null) {
            curr = curr.next;
            lenB++;
        }
        // fast forward the lists till the point both the lengths are equal
        // if listA is > listB
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        // if listBis > listA
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }
        // both the lists are of equal length, now check for the intersection node
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
