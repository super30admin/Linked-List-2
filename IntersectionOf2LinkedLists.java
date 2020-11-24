package S30.LinkedList2;

/*
Time Complexity : O(M + N)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class IntersectionOf2LinkedLists {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;

        while(a != b){
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }
        return a;
    }
}
