// Time Complexity : O(l1 + l2)
// Space Complexity : O(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      
        ListNode tempA = headA, tempB = headB;

        while(tempA != tempB)
        {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }

        return tempA;
    }
}