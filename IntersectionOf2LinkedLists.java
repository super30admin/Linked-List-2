//TC: O(a's size + b's size)
//SC: O(1)
//approach: two pointers

public class IntersectionOf2LinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA=headA;
        ListNode curB=headB;
        while(curA!=null && curB!=null){
            curA=curA.next;
            curB=curB.next;
        }

        while(curB!=null){
            curB=curB.next;
            headB=headB.next;
        }

        while(curA!=null){
            curA=curA.next;
            headA=headA.next;
        }

        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}
