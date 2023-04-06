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
    
        ListNode p1 = headA;
        ListNode p2 = headB;
        
        while(p1!=p2){
            
            p1 = p1==null ? headB : p1.next;
            p2 = p2==null ? headA : p2.next;

//             if(p1 == null){
//                  p1 = headB;
//             }
//             else{
//                 p1 = p1.next;
//             }
            
//             if(p2 == null){
                
//                 p2 = headA;
//             }
//             else{
//                 p2 = p2.next;
//             }
             
        }
        return p1;
    }
    
//      public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    
//         ListNode curr = headA;
//         int lenA = 0;
         
//         while(curr!= null){
//              curr = curr.next;
//              lenA++;
//         }
         
//         curr = headB;
//         int lenB = 0;
//         while(curr!= null){
//              curr = curr.next;
//              lenB++;
//          }
         
//         while(lenA > lenB){
//             headA = headA.next;
//             lenA--;
//         }
         
//         while(lenB > lenA){
//             headB = headB.next;
//             lenB--;
//         }
         
//         while(headA != headB){
//             headA = headA.next;
//             headB = headB.next;
//         }
//         return headA;     
//      }
  
}
