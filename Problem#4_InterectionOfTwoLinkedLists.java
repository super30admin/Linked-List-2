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
        if(headA == null || headB ==null){
            return null;
        }
        ListNode curr = headA;
        //Calculate the lengths of both lists   
        int lenA = 0, lenB = 0;
        ListNode ptrA = headA;
        while(headA!=null){
            lenA++;
            headA = headA.next;
        }
        curr = headB;
        ListNode ptrB = headB;
        while(headB!=null){
            lenB++;
            headB = headB.next;
        }
        while(lenA!=lenB){
            if(lenA>lenB){
                lenA--;
                ptrA = ptrA.next;
            }else if(lenB>lenA){
                lenB--;
                ptrB = ptrB.next;
            }
        }
        
        // System.out.println("Afterwards lenA: "+lenA+" lenB: "+lenB);
        while(ptrA!=null && ptrB!=null){
            if(ptrA == ptrB) return ptrA;
            ptrA=ptrA.next;
            ptrB = ptrB.next;
        }
        return null;
        
    }
}