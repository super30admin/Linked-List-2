package LinkedListII;

// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class IntersectionOfTwoLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lnA = 0;
        ListNode curr = headA;
        while(curr != null)
        {
            curr = curr.next;
            lnA++;
        }

        int lnB = 0;
        curr = headB;
        while(curr != null)
        {
            curr = curr.next;
            lnB++;
        }

        while(lnA > lnB)
        {
            headA = headA.next;
            lnA--;
        }

        while(lnB > lnA)
        {
            headB = headB.next;
            lnB--;
        }

        while(headA != headB)
        {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}
