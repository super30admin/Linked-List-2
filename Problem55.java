// Time Complexity : O(M+N)
// Space Complexity : O(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode currA = headA; ListNode currB = headB;

        while(currA != currB) {
            currA = currA.next;
            currB = currB.next;

            if (currA == null && currB == null) return null;

            if (currA == null) {
                currA = headB;
            }

            if (currB == null) {
                currB = headA;
            }
        }

        return currA;
        
    }
}