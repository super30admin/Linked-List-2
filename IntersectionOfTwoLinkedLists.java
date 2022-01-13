// Time Complexity : O(lenA + lenB)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class IntersectionOfTwoLinkedLists {
    //    Definition for singly-linked list.
        public class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
                val = x;
                next = null;
            }
        }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        //  Find length of LinkedList A
        while (nodeA != null) {
            nodeA = nodeA.next;
            lenA++;
        }

        //  Find length of LinkedList B
        while (nodeB != null) {
            nodeB = nodeB.next;
            lenB++;
        }

        nodeA = headA;
        nodeB = headB;

        //  Make both the starting pointers equidistant from the intersection
        while (lenA > lenB) {
            nodeA = nodeA.next;
            lenA--;
        }

        while (lenB > lenA) {
            nodeB = nodeB.next;
            lenB--;
        }

        //  Reach the intersection
        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return nodeA;
    }
}
