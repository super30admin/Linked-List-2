// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * 1st Approach can be to use a Set of ListNode references
 * and return the first node which is already present in the set.
 * 2nd Approach can be to calculate the length of both the lists and position the pointers
 * at the same distance from the intersection of the list and then move the pointers
 * until they meet.
 */

public class Problem4 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;

        ListNode temp = headA;
        while (temp != null) {
            len1++;
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            len2++;
            temp = temp.next;
        }

        while (len1 > len2) {
            headA = headA.next;
            len1--;
        }

        while (len1 < len2) {
            headB = headB.next;
            len2--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }


        return headA;

    }
}
