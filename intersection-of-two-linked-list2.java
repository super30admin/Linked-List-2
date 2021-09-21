//Time complexity: O(N + M)
//Space complexity: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode pointerA = headA;
       ListNode pointerB = headB;
       while(pointerA != pointerB ) {
           if(pointerA == null) {
               pointerA = headB;
           } 
           else {
               pointerA = pointerA.next;
           }
           if(pointerB == null) {
               pointerB = headA;
           }
           else {
               pointerB = pointerB.next;
           }
           
       }
      return pointerA;
    }
}