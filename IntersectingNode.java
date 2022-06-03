// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class IntersectingNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;

        ListNode curr = headA;

        while(curr != null){
            curr = curr.next;
            lengthA++;
        }

        curr = headB;

        while(curr != null){
            curr = curr.next;
            lengthB++;
        }

        while(lengthA > lengthB){
            headA = headA.next;
            lengthA--;
        }

        while(lengthB > lengthA){
            headB = headB.next;
            lengthB--;
        }

        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}
