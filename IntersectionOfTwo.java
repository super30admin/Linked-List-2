// Time Complexity : O(m + n), where m = length of list A, n = length of list B
// Space Complexity : O(1), since we only use pointers and counters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially aligned the wrong list pointer, but corrected it

// Approach:
// 1) Count lengths of both lists.
// 2) Advance the pointer of the longer list so that both lists have the same number of nodes remaining.
// 3) Traverse both lists in parallel until the pointers meet.
//    - If they meet at a node, that’s the intersection node.
//    - If they both reach null, there is no intersection.


public class IntersectionOfTwo {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1 = 0;
        ListNode dummy1 = headA;
        ListNode dummy2 = headB;

        // Count length of list A
        while (dummy1 != null) {
            dummy1 = dummy1.next;
            count1++;
        }

        // Count length of list B
        int count2 = 0;
        while (dummy2 != null) {
            dummy2 = dummy2.next;
            count2++;
        }

        // Reset pointers
        dummy1 = headA;
        dummy2 = headB;

        // Advance longer list
        while (count1 > count2) {
            dummy1 = dummy1.next;
            count1--;
        }
        while (count2 > count1) {
            dummy2 = dummy2.next;
            count2--;
        }

        // Traverse in sync until intersection found or both null
        while (dummy1 != dummy2) {
            dummy1 = dummy1.next;
            dummy2 = dummy2.next;
        }

        return dummy1; // either intersection node or null
    }

    // --- Main method for testing ---
    public static void main(String[] args) {
        // Create intersection scenario:
        ListNode intersect = new ListNode(5);
        intersect.next = new ListNode(6);
        intersect.next.next = new ListNode(7);

        // List A
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(9);
        headA.next.next = intersect;

        // List B
        ListNode headB = new ListNode(3);
        headB.next = intersect;

        IntersectionOfTwo sol = new IntersectionOfTwo();
        ListNode ans = sol.getIntersectionNode(headA, headB);

        if (ans != null) {
            System.out.println("Intersection node value: " + ans.val);
        } else {
            System.out.println("No intersection.");
        }

        // Example with no intersection
        ListNode a1 = new ListNode(2);
        a1.next = new ListNode(4);
        ListNode b1 = new ListNode(6);
        b1.next = new ListNode(8);

        ListNode ans2 = sol.getIntersectionNode(a1, b1);
        System.out.println("No intersection case: " + (ans2 == null ? "Correct" : "Wrong"));
    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

}
