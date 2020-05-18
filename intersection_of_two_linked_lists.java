/**
Time Complexity: O(2N) = O(N)
Space Complexity: Constant space, O(1).
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
        int lena = 0 , lenb = 0;
        ListNode curr = headA;
        while(curr!=null)
        {
            lena++;
            curr = curr.next;
        }
        curr = headB;
        while(curr!=null)
        {
            lenb++;
            curr = curr.next;
        }
        while(lena > lenb)
        {
            headA = headA.next;
            lena--;
        }
        while(lenb > lena)
        {
            headB = headB.next;
            lenb--;
        }
        while(headA!=headB)
        {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
        
    }
}