// Time : O(m+n)
//Space : O(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        int lenA = 0;
        while (A != null) {
            A = A.next;
            lenA++;
        }
        int lenB = 0;
        while (B != null) {
            B = B.next;
            lenB++;
        }
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}