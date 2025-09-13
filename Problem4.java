// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * First we calculate the size of both linked lists. We move the head pointer to x steps on list with bigger size where x is the difference between size of two lists.
 * We iterate through both lists and we return the first node where node is same for both lists.
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        ListNode current = headA;
        while(current != null) {
            sizeA++;
            current = current.next;
        }

        int sizeB = 0;
        current = headB;
        while(current != null) {
            sizeB++;
            current = current.next;
        }

        if (sizeA > sizeB) {
            while(sizeA != sizeB) {
                headA = headA.next;
                sizeA--;
            }
        }

        if (sizeB > sizeA) {
            while (sizeA != sizeB) {
                headB = headB.next;
                sizeB--;
            }
        }

        while (headA != null) {
            if (headA == headB)
                return headA;
            headA = headA.next;
            headB= headB.next;
        }

        return headA;
    }
}