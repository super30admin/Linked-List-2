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

//time-o(m+n)
//space-o(1)
//passed in leetcode- yes

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=1;
        int lenB=1;
        ListNode ptrA = headA;
        ListNode ptrB = headB;
        
        //check lengths of both lists
        while(ptrA!=null) 
        {
            ptrA=ptrA.next;
            lenA++;
        }
        while(ptrB!=null)
        {
            ptrB=ptrB.next;
            lenB++;
        }
        
        //set ptrs to head again
        ptrA= headA;
        ptrB= headB;
        
        //check which list is longer, accordingly move ptrs, to make sure, we meet at intersection
        if(lenA>lenB)
        {
            while(lenA!=lenB)
            {
                ptrA = ptrA.next;
                lenA--;
                
            }
        }
        if(lenB>lenA)
        {
            while(lenB!=lenA)
            {
                ptrB = ptrB.next;
                lenB--;
                
            }
        }
        
        //to check if we meet at intersection, move both at 1x speed
        while(ptrA!=ptrB)
        {
            ptrA=ptrA.next;
            ptrB=ptrB.next;
            
        }
        
        if(ptrA==ptrB) return ptrA;
        else{
            return null;
        }
        
    }
}