// Time Complexity :O(m+n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// Calculate lengths of both linked lists and align the longer list to the same remaining length.
// Traverse both lists simultaneously until the nodes match.
// Return the intersection node, or null if no intersection exists.

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = 0;
        int lenB = 0;

        ListNode curr1 = headA;
        ListNode curr2 = headB;

        // Calculate length of list A
        while (curr1 != null) {
            lenA++;
            curr1 = curr1.next;
        }

        // Calculate length of list B
        while (curr2 != null) {
            lenB++;
            curr2 = curr2.next;
        }

        // Align both lists by advancing the longer one
        while (Math.abs(lenA - lenB) > 0) {
            if (lenA > lenB) {
                headA = headA.next;
                lenA--;
            } else {
                headB = headB.next;
                lenB--;
            }
        }

        // Move both pointers until they meet
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        // Either intersection node or null
        return headA;
    }
}
