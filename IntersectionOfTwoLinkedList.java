// TC: O(m + n)
// SC: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA, currB;
        currA = headA;
        currB = headB;
        while(currA != null && currB != null) {
            currA = currA.next;
            currB = currB.next;
        }
        while(currB != null) {
            currB = currB.next;
            headB = headB.next;
        }
        while(currA != null) {
            currA = currA.next;
            headA = headA.next;
        }
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}