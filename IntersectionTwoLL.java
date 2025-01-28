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
public class IntersectionTwoLL {
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

       int len1 =0;
       int len2 =0;
        ListNode h1 = headA;
        ListNode h2 = headB;

        while (h1!= null){
            h1 = h1.next;
            len1 ++;
        }

        while (h2!= null){
            h2 = h2.next;
            len2 ++;
        }
        ListNode a = headA;
        ListNode b = headB;

       while (len1 > len2){
           a = a.next;
           len1--; 
       } 
      while(len2> len1) {
           b = b.next;
           len2--;
       } 
       while (a!= b){
        a= a.next;
        b= b.next;
       }
        return a;

    }
}