public class ex55 {
    
 // Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        int lengthA=0; int lengthB = 0;
        ListNode current = headA;
        while(current != null){
            current = current.next;
            lengthA++;
        }
        current = headB;
        while(current != null){
            current = current.next;
            lengthB++;
        } 
        while(lengthA < lengthB){
            headB = headB.next;
            lengthB--;
        }
         while(lengthB < lengthA){
            headA = headA.next;
             lengthA--;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
}
