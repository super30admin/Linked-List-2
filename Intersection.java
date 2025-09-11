//Time Complexity: O(n)
//Space Complexity: O(1)
//Approach: The idea is to find the intersection point of two lists, if any
//it is possible that the two lists have different lengths, but from the point of intersection, they will have the same length
//which means first we find the length of the two lists, then traverse the longer list until the diff between the two is 0
//traverse both the lists together until the reference of list a and list b is the same (if there's intersection), otherwise, both lists will be null, return any of the two lists
public class Intersection {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lengthA = 0, lengthB = 0;
        ListNode curr = headA;

        while (curr != null) {
            lengthA++;
            curr = curr.next;
        }

        curr = headB;
        while (curr != null) {
            lengthB++;
            curr = curr.next;
        }

        for (int i = 0; i < lengthA - lengthB; i++) {
            headA = headA.next;
        }

        for (int i = 0; i < lengthB - lengthA; i++) {
            headB = headB.next;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public static void main(String[] args) {
        final Intersection intersection = new Intersection();
        ListNode common = new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7))));
        ListNode headA = new ListNode(1, new ListNode(2, new ListNode(3, common)));
        ListNode headB = new ListNode(9, new ListNode(11, new ListNode(12, new ListNode(13, new ListNode(10, common)))));

        common = intersection.getIntersectionNode(headA, headB);
        System.out.println(common.val); //4

        headA = new ListNode(2, new ListNode(5, new ListNode(9)));
        headB = new ListNode(1, new ListNode(6));
        common = intersection.getIntersectionNode(headA, headB);
        assert common == null;
    }
}
