//Time Complexity: O(n)
//Space Complexity: O(1)
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int countA = 0;
        ListNode curr = headA;
        while(curr!=null){
            curr = curr.next;
            countA++;
        }
        int countB = 0;
        curr = headB;
        while(curr!=null){
            curr = curr.next;
            countB++;
        }

        while(countA>countB) {
            headA = headA.next;
            countA--;
        }
        while(countB>countA) {
            headB = headB.next;
            countB--;
        }

        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }

        return headA;

    }
}
