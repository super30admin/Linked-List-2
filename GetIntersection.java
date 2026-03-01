public class GetIntersection {
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;

        ListNode currHA = headA;
        ListNode currHB = headB;

        while (currA != currB ) {
            if (currA == null) {
                currA = currHA == headA ? headB : headA;
                currHA = currA;
            } else if (currB == null) {
                currB = currHB == headB ? headA : headB;
                currHB = currB;
            } else {
                currA = currA.next;
                currB = currB.next;
            }

        }
        return currA;
    }
}