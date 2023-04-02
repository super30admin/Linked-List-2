//Leetcode - 160
//TC - O(M+N)
//SC - O(1)
public class IntersectionOfLinkedList {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1=0;
        ListNode curr = headA;
        while(curr != null) {
            l1++;
            curr = curr.next;
        }
        int l2=0;
        curr = headB;
        while(curr != null) {
            l2++;
            curr = curr.next;
        }
        while(l1 > l2) {
            headA = headA.next;
            l1--;
        }
        while(l2 > l1) {
            headB = headB.next;
            l2--;
        }
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
