// Time Complexity : O(n + m) = O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = 0;
        ListNode currA = headA;
        //find length of first linkedlist
        while (currA != null) {
            currA = currA.next;
            lengthA++;
        }
        int lengthB = 0;
        ListNode currB = headB;
        //find length of first linkedlist
        while (currB != null) {
            currB = currB.next;
            lengthB++;
        }

        while (lengthA > lengthB) {
            headA = headA.next;
            lengthA--;
        }
        while (lengthB > lengthA) {
            headB = headB.next;
            lengthB--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;

    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

}
