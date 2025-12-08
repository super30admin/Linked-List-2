// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//   Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
public class IntersectionTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode curr = headA;
        while(null != curr)
        {
            lenA++;
            curr = curr.next;
        }
        curr = headB;
        while(null != curr)
        {
            lenB++;
            curr = curr.next;
        }
        while(lenA > lenB)
        {
            lenA--;
            headA = headA.next;
        }
        while(lenB > lenA)
        {
            lenB--;
            headB = headB.next;
        }
        while(headA != headB)
        {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}