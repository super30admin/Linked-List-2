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
public class IntersectionOfLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         int lenA=0;
        int lenB=0;
        ListNode cur = headA;
        while(cur !=null)
        {
            cur =cur.next;
            lenA++;
        }
        cur = headB;
        while(cur !=null)
        {
            cur =cur.next;
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
// Time Complexity :O(lenA+lenB)
// Space Complexity : O(1)
