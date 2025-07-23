//Time Complexity: O(m + n) — where m and n are the lengths of the two linked lists.
//Space Complexity: O(1) — uses only constant extra space (no hash sets or arrays).

//Use two pointers starting at the heads of both lists.
//When either pointer reaches the end, redirect it to the head of the other list.
//They will meet at the intersection node or at null if no intersection exists.

public class problem4 {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        
        ListNode pointer1 = head1, pointer2 = head2;

        while (pointer1 != pointer2) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;

            if (pointer1 == null && pointer2 == null) return null;

            if (pointer1 == null) {
                pointer1 = head2;
            }

            if (pointer2 == null) {
                pointer2 = head1;
            }
        }

        return pointer1;
    }
}
