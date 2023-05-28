// Time Complexity : O(n)
// Space Complexity : O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null && headB == null) {
            return null;
        }

        int lenA = 0, lenB = 0;

        // find lengths of the 2 lists
        ListNode ptr = headA;
        while(ptr != null) {
            lenA++;
            ptr = ptr.next;
        }
        ptr = headB;
        while(ptr != null) {
            lenB++;
            ptr = ptr.next;
        }

        // then move head of the larger list forward by diff
        if(lenA > lenB) {
            for(int i=0; i < lenA-lenB && headA != null; i++) {
                headA = headA.next;
            }
        } else if(lenA < lenB) {
            for(int i=0; i < lenB-lenA && headB != null; i++) {
                headB = headB.next;
            }
        }

        // then find common node
        while(headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}