// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully: Yes
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
public class IntersectionLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        int lenA = 0, lenB = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        //find the length of first LL
        while(nodeA != null) {
            lenA++;
            nodeA = nodeA.next;
        }

        //find the length of second LL
        while(nodeB != null) {
            lenB++;
            nodeB = nodeB.next;
        }

        //move first LL till its length is equal to second LL length
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }

        //move second LL till its length is equal to first LL length
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }

        //when the length of both LL are equal, travel one by one till they intersect(become equal)
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        //return the intersection node
        return headA;
    }
}