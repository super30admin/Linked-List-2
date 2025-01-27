package LinkedList2;

//Time Complexity : O(N+M)
//Space Complexity : O(1)

public class IntersectionOfLinkedLIst {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null) {
            return null;
        }
        int lenA = findLength(headA);
        int lenB = findLength(headB);
        while(lenA > lenB) {
            headA =headA.next;
            lenA--;
        }

        while(lenB > lenA) {
            lenB--;
            headB = headB.next;
        }

        while(headA!=headB) {
            headB = headB.next;
            headA = headA.next;
        }
        return headA;
    }

    public int findLength(ListNode head)  {
        ListNode node = head;
        int count = 0;
        while(node!=null) {
            node = node.next;
            count ++;
        }
        return count;
    }
}
