package Linked-List-2;

public class Problem4 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode first = headA;
        int lenA=0;

        while(first !=null){
            first = first.next;
            lenA++;
        }

        first = headB;
        int lenB=0;

        while(first !=null){
            first = first.next;
            lenB++;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;
        while(lenA>lenB){
            p1 = p1.next;
            lenA--;
        }

        while(lenB>lenA){
            p2 = p2.next;
            lenB--;
        }

        while(p1!=p2){
            p1=p1.next;
            p2 = p2.next;
        }

        return p1;

    }
}
