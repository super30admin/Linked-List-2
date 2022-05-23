//Time Complexity: O(m+n)
//Space Complexity:o(1)
//Did this code successfully run on Leetcode :Yes
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lengthA = 0;
        int lengthB = 0;
        ListNode ptr = headA;

        while (ptr != null) {
            ptr = ptr.next;
            lengthA++;
        }
        ptr = headB;

        while (ptr != null) {
            ptr = ptr.next;
            lengthB++;
        }
        if (lengthA >= lengthB) {
            int count = lengthA - lengthB;
            while (count > 0) {
                headA = headA.next;
                count--;
            }
        } else {
            int count = lengthB - lengthA;
            while (count > 0) {
                headB = headB.next;
                count--;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}