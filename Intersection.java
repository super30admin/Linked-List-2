/** Write a program to find the node at which the intersection of two singly linked lists begins.
* TC O(N) SC O(1)
*code was submitted in leetcode
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode head1 = headA, head2 = headB;
        int lenA=0, lenB=0;
        while(headA != null) {
            headA = headA.next;
            lenA++;
        }
        while(headB != null) {
            headB = headB.next;
            lenB++;
        }
        
        int increment = Math.abs(lenA - lenB);
        boolean first = (lenA - lenB) > 0 ? true : false;
        if (first) { 
            while (increment > 0) {
                head1 = head1.next;
                increment --;
            }
        }else {
            while (increment > 0) {
                head2 = head2.next;
                increment --;
            }
        }
        while(head1 != null && head2 != null) {
            if (head1 == null || head2 == null) {
                return null;
            }
            if (head1 == head2)
            {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }
}
