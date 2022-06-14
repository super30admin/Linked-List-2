/**
Time Complexity : O(n)
Space Complexity : O(1)

**/

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
        
        //Calculate len of the A linked list
        ListNode curr = headA;
        int lenA = 0;
        while(curr != null){
            curr = curr.next;
            lenA++;
        }
        
        //Calculate len of the B linked list
        curr = headB;
        int lenB = 0;
        
        while(curr != null){
            curr = curr.next;

            lenB++;
        }
        
    //Move headA until lenA = lenB 
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        
            //Move headA until lenA = lenB 
        while(lenA < lenB){
            headB = headB.next;
            lenB--;
        }
        
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
}