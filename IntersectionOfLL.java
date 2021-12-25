// Time Complexity : O(n + m)
// Space Complexity : O(1)
public class IntersectionOfLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        
        // move each linked list ahead until they become of same length
        int lenA = 0;
        ListNode dummy = headA;
        while(dummy != null)
        {
            dummy = dummy.next;
            lenA++;
        }
        
        int lenB = 0;
        dummy = headB;
        while(dummy != null)
        {
            dummy = dummy.next;
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
        // make both list of same length
        while(headA != headB)
        {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA; // can also return headB as they both are same
    }
}
