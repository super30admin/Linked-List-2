public class IntersectionOfLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode listA=headA;
        ListNode listB=headB;
        while(listA != null && listB != null){
            listA= listA.next;
            listB= listB.next;
        }
        while(listB !=null){
            listB=listB.next;
            headB=headB.next;
        }
        while(listA !=null){
            listA=listA.next;
            headA=headA.next;
        }
        while(headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
