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
        ListNode A1 = headA;
        ListNode B1 = headB;
    
        int lA = 0;   
        while(A1 != null){
            A1 = A1.next;
            lA++;  
        }  
        
        int lB = 0;   
        while(B1 != null){
            B1 = B1.next;
            lB++;  
        }
        
        A1 = headA;
        B1 = headB;
        int length1;
        if(lA > lB){
            length1 = lA - lB;
            while(length1 != 0){
                A1 = A1.next;
                length1--;
            }
            
        } else {
            length1 = lB - lA;
             while(length1 != 0){
                B1 = B1.next;
                length1--;
            }
        }
        
        while(A1 != B1){
            A1 = A1.next;
            B1 = B1.next;
        }
        return A1;
       }
}