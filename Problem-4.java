// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Find lengths of list A and B
// move the head of the greater length list untill both list are of smae length
// once they are at same lenght then increment both list by one and check if intersection is found
// return when nodes match (even in no itersection null will be matched and returned)
class IntersectionOfTwoList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr = headA;
        int lenA = 0, lenB = 0;
        // find lenA
        while (curr != null) {
            lenA++;
            curr = curr.next;
        }

        // find lenB
        curr = headB;
        while (curr != null) {
            lenB++;
            curr = curr.next;
        }

        // move the greater length list untill both lists are of same length
        while (lenA > lenB) {
            lenA--;
            headA = headA.next;
        }

        while (lenA < lenB) {
            lenB--;
            headB = headB.next;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}