/**
 * space complexity is O(1)
 * time complexity is O(n+m)
 */

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        
        return lenA > lenB ? intersect(headA, headB, lenA-lenB) : intersect(headB, headA, lenB-lenA);
    }
    
    private ListNode intersect(ListNode headA, ListNode headB, int diff) {
        ListNode iterA = headA;
        while(diff > 0) {
            iterA = iterA.next;
            diff--;
        }
        
        ListNode iterB = headB;
        
        while(iterA != iterB) {
            iterA = iterA.next;
            iterB = iterB.next;
        }
        return iterA;
    }
    
    private int getLength(ListNode head) {
        int len = 0;
        ListNode iter = head;
        
        while(iter != null) {
            iter = iter.next;
            len++;
        }
        return len;
    }

    class ListNode
    {
        int data ;
        ListNode next;
        ListNode(int d)
        {
            data = d;
            next = null;
        }
    }
}