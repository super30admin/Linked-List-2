/*
Approach
Use two pointers starting at headA and headB, moving one step at a time.
When a pointer reaches the end, switch it to the other list's head, making both pointers travel the same total distance.
They will meet at the intersection node, or both become null if there is no intersection.

Time Complexity: O(m + n)
Space Complexity: O(1)
*/
public class Intersectionof2inkedList {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {

            // When a reaches the end, move it to headB
            a = (a == null) ? headB : a.next;

            // When b reaches the end, move it to headA
            b = (b == null) ? headA : b.next;
        }

        return a;
    }
}

