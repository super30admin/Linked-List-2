/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       ListNode currentA=headA;
       ListNode currentB=headB;
       while(currentA!=null && currentB!=null){
           currentA=currentA.next;
           currentB=currentB.next;
       }
       while(currentB!=null){
           currentB=currentB.next;
           headB=headB.next;
       }
       while(currentA!=null){
           currentA=currentA.next;
           headA=headA.next;
       }
       while(headA!=headB){
           headA=headA.next;
           headB=headB.next;
       }
       return headA;
   }
}