// Time complexity: O(m + n) where m and n are the number of nodes in the linked lists.
// Space complexity: O(1).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
public class IntersectionOfLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode currA = headA;
        ListNode currB = headB;
        int lenA = 0;
        int lenB = 0;
        while(currA != null) {
            lenA++;
            currA = currA.next;
        }
        while(currB != null) {
            lenB++;
            currB = currB.next;
        }
        currA = headA;
        currB = headB;
        // Move the pointer of longer list forward so that both lists have same length.
        while(lenA > lenB) {
            currA = currA.next;
            lenA--;
        }
        while(lenB > lenA) {
            currB = currB.next;
            lenB--;
        }
        while(currA != currB && (currA != null || currB != null)) { // If not equal, they will be null finally.)
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }
}