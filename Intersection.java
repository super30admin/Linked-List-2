// Time Complexity : O(n + m); n = len of linkedlist A, m = len of linkedList B
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Intersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        int sizeB = 0;

        ListNode a = headA;
        ListNode b = headB;

        while (a != null) {
            sizeA++;
            a = a.next;
        }

        while (b != null) {
            sizeB++;
            b = b.next;
        }

        a = headA;
        b = headB;

        if (sizeB > sizeA) {
            while (sizeB - sizeA != 0){
                sizeB--;
                b = b.next;
            }
        }
        else {
            while (sizeA - sizeB != 0){
                sizeA--;
                a = a.next;
            }
        }
        while (a != null && a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }
}
