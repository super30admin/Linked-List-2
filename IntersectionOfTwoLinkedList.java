public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // TC:O(m+n);
        // SC:O(1);
        int countA = 0;
        int countB = 0;

        ListNode curr = headA;
        //Calculating number of nodes in A
        while(curr != null){
            curr = curr.next;
            countA++;
        }
        //Calculating number of nodes in B
        curr = headB;
        while(curr != null){
            curr = curr.next;
            countB++;
        }
        while(countA > countB){
            headA = headA.next;
            countA--;
        }
        while(countB > countA){
            headB = headB.next;
            countB--;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA; // or headB
    }
}
