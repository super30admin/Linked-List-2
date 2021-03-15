// Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)
// Time Complexity : O(N*M)
// Space Complexity : O(1)
public class intersectionofTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null) {
            ListNode pB = headB;
            while (pB != null) {
                if (headA == pB) return headA;
                pB = pB.next;
            }
            headA = headA.next;
        }
        return null;
    }
}
