//time O(m+n)
//space O(1)

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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null) return  headB;
        if(headB == null) return headA;
        
        ListNode curr = headA;
        
        int lenA = 0; int lenB = 0;
        while(curr != null) {
            lenA++;
            curr = curr.next;
        }
        
        curr = headB;
        while(curr != null) {
            lenB++;
            curr = curr.next;
        }
        
        if(lenB > lenA) {
            int diff = lenB - lenA;
            while(diff != 0) {
                headB = headB.next;
                diff--;
            }
        } else if(lenA > lenB) {
            int diff = lenA - lenB;
            while(diff != 0) {
                headA = headA.next;
                diff--;
            }
        }
        
        while(headA != headB) {
            headB = headB.next;
            headA = headA.next;
        }
        return headA;
        
    }
}
