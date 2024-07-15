
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 *
 * TC --> O(n)
 * SC --> O(1)
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr1 = headA;
        ListNode curr2 = headB;
        int l1 = 0;
        int l2 = 0;
        while (curr1 != null) {
            l1++;
            curr1 = curr1.next;
        }//while
        while (curr2 != null) {
            l2++;
            curr2 = curr2.next;
        }//while
        curr1 = headA;
        curr2 = headB;
        int diff = Math.abs(l1 - l2);
        if (l1 > l2) {

            while (diff != 0) {
                curr1 = curr1.next;
                diff--;
            }

        }//if
        else {
            while (diff != 0) {
                curr2 = curr2.next;
                diff--;
            }//while
        }//else

        while (curr1 != null && curr2 != null) {
            if (curr1 == curr2) {
                return curr1;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }//while

        return null;

    }//method
}//class
