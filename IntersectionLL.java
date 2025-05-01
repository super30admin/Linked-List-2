//Time Complexity: O(n)
//Space Complexity: O(1)

  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

public class IntersectionLL {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        while(a!= b){
            a = a== null? headB : a.next;
            b = b == null? headA : b.next;
        }
        return a;
    }
}
