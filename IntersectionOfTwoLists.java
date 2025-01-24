/**
 * Time complexity: O(max(m,n))
 * Space complexity: O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 *
 * Approach:
 * 1. Count length of both lists
 * 2. leave any excess nodes out and check from the point from where both lists are same size
 * 3. If there is an intersection found, return that node. Else null is returned
 */
public class IntersectionOfTwoLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int m = 0;
        ListNode curr = headA;
        // count headA len
        while (curr != null) {
            m++;
            curr = curr.next;
        }

        int n = 0;
        curr = headB;
        // count headB len
        while (curr != null) {
            n++;
            curr = curr.next;
        }

        ListNode currA = headA;
        ListNode currB = headB;

        while (m > n) {
            currA = currA.next;
            m--;
        }

        while (m < n) {
            currB = currB.next;
            n--;
        }

        // look for intersections
        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }

        return currA;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(1);
        ListNode a1 = new ListNode(2);
        headA.next = a1;
        ListNode a2 = new ListNode(3);
        a1.next = a2;
        ListNode a3 = new ListNode(4);
        a2.next = a3;
        ListNode a4 = new ListNode(5);
        a3.next = a4;
        a4.next = new ListNode(6);

        ListNode headB = new ListNode(1);
        ListNode b1 = new ListNode(6);
        headB.next = b1;
        b1.next = a3;

        IntersectionOfTwoLists obj = new IntersectionOfTwoLists();
        ListNode intersectionNode = obj.getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);
        assert (intersectionNode.val == 4);
    }
}
