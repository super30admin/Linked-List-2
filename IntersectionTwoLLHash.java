import java.util.*;

public class IntersectionTwoLLHash {
    public ListNode intersectionTwoLLHash(ListNode headA, ListNode headB) {
        HashSet<ListNode> hs = new HashSet<>();

        while (headA != null) {
            hs.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (hs.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
