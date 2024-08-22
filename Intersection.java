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

// Time complexity = O(m+n)
// Space Complexity = O(1)
public class Intersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0;
        int l2 = 0;
        ListNode lA = headA;
        ListNode lB = headB;
        while(lA!=null) {
            lA= lA.next;
            l1++;
        }
        while(lB!=null) {
            lB = lB.next;
            l2++;
        }
        // got the lengths.
        int count=0;
        int j=0;
        if(l1>l2) {
            count=l1-l2;
            while( j < count ) {
                headA= headA.next;
                j++;
            }
        }else {
            count=l2-l1;
            while( j < count ) {
                headB= headB.next;
                j++;
            }
        }
        while(headA!= headB) {
            headA= headA.next;
            headB= headB.next;
        }
        return headA;
    }
}