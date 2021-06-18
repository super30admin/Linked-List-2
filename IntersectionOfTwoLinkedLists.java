// TC: O(n)
// SC: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA, countB, diff;
        countA = 0;
        countB = 0;
        ListNode tempA, tempB;
        tempA = headA;
        tempB = headB;
        while(tempA != null) {
            countA++;
            tempA = tempA.next;
        }
        while(tempB != null) {
            countB++;
            tempB = tempB.next;
        }
        diff = Math.abs(countA - countB);
        if(countA > countB) {
            while(diff > 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            while(diff > 0) {
                headB = headB.next;
                diff--;
            }
        }
        while(headA != null && headB != null) {
            if(headA == headB) {
                break;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}