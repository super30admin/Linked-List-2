// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // Get the lengths of both linked lists
        ListNode curr = headA;
        int l1 = 0;
        while (curr != null) {
            curr = curr.next;
            l1++;
        }

        curr = headB;
        int l2 = 0;
        while (curr != null) {
            curr = curr.next;
            l2++;
        }

        // we got both l1 and l2
        // Just move till they are equidistant from the Intersection Node
        while (l1 > l2) {
            headA = headA.next;
            l1--;
        }

        while (l2 > l1) {
            headB = headB.next;
            l2--;
        }

        // Now they are at the same distance from the intersection
        // Just Move with same speed ..u will meet each other !!
        while (headA != headB) {

            headA = headA.next;
            headB = headB.next;

        }

        return headA;

    }
}