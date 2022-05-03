
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class ListIntersection {
    // Time complexity: O(max(m,n)) m - number of nodes in listA & n - number of nodes in listB
    // Space complexity: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        // First iteration counteracts the difference in length
        // Second iteration will find the intersection, if they intersect
        // In case, they don't intersect at all then the intersecting point will be the tail node of both which is null
        while(a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
