// Time Complexity : O(N)
// Space Complexity : O(1)
public class IntersectionListsSolution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { 
            val = x; 
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int lenA = 0, lenB = 0;
        ListNode cur = headA;
        while(cur!=null) {
            cur = cur.next;
            lenA++;
        }
        cur = headB;
        while(cur!=null) {
            cur = cur.next;
            lenB++;
        }
        
        while(lenA < lenB) {
            headB = headB.next;
            lenB--;
        }
        while(lenB < lenA) {
            headA = headA.next;
            lenA--;
        }
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headB;
    }
}