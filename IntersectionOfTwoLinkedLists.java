// TC : O(m + n)
// SC : O(1)

package S30_Codes.Linked_List_2;

public class IntersectionOfTwoLinkedLists {
}


class Solution3 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int nodesOfA = countNodes(headA);
        int nodesOfB = countNodes(headB);

        if(nodesOfA > nodesOfB)
            headA = skipNodes(headA, nodesOfA-nodesOfB);
        else if(nodesOfB > nodesOfA)
            headB = skipNodes(headB, nodesOfB-nodesOfA);

        while(headA != null && headB != null && headA != headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private ListNode skipNodes(ListNode head, int count){
        while(count > 0){
            count --;
            head = head.next;
        }
        return head;
    }

    private int countNodes(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
}