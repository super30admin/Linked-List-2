// Time Complexity : O(m + n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * We first find the length of the 2 linked lists and find out the longer list. For the longer list,
 * we move the head until the node where the 2 lists become equal. After this, we keep looping on to the next node until
 * we find that one node which exists in both the lists.
 */
//160. Intersection of Two Linked Lists (Easy) - https://leetcode.com/problems/intersection-of-two-linked-lists/
public class Intersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr = headA;

        int lenA = 0;

        while(curr != null)
        {
            curr = curr.next;
            lenA++;
        }

        int lenB = 0;
        curr = headB;
        while(curr != null)
        {
            curr = curr.next;
            lenB++;
        }

        while(lenA > lenB)
        {
            headA = headA.next;
            lenA--;
        }

        while(lenB > lenA)
        {
            headB = headB.next;
            lenB--;
        }

        while(headA != headB)
        {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}