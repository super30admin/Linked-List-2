// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach
class IntersectingLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null)
            return headA;

        int m = lengthOf(headA);
        int n = lengthOf(headB);

        int k = 0;
        if (m <= n) {
            // System.out.println("m > n");
            while (k < n - m && headB.next != null) {
                headB = headB.next;
                k++;
            }
        } else {
            // System.out.println("m <= n");
            while (k < m - n && headA.next != null) {
                headA = headA.next;
                k++;
            }
        }

        // System.out.println("lenA: " + m + "-> " + headA.val);
        // System.out.println("lenB: " + n + "-> " + headB.val);
        // System.out.println("k: " + k);

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int lengthOf(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        return n;
    }
}
