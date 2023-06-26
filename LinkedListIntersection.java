public class LinkedListIntersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int listA=0;
        int listB=0;
        ListNode curr=headA;
        while(curr!=null){
            listA++;
            curr=curr.next;
        }
        curr=headB;
        while(curr!=null){
            listB++;
            curr=curr.next;
        }
        while(listA>listB){
            headA=headA.next;
            listA--;
        }
        while(listB>listA){
            headB=headB.next;
            listB--;
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}
