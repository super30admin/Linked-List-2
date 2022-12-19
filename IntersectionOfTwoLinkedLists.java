// Time Complexity : O(m+n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class IntersectionOfTwoLinkedLists {
    
    
 // Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lenA = 0;
        ListNode headAT = headA;
        while (headAT != null){
            lenA++;
            headAT = headAT.next;
        }
        ListNode headBT = headB;
        int lenB = 0;
        while (headBT != null){
            lenB++;
            headBT = headBT.next;
        }

        if (lenA > lenB){
            while(lenA > lenB){
                headA= headA.next;
                lenA--;
            }
        } else if (lenB > lenA){
            while(lenB > lenA){
                headB= headB.next;
                lenB--;
            }
        }

        while (headA != null && headB != null){
            if (headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
        
    }


}
