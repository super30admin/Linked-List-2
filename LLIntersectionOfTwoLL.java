/**
 * LeetCode - 160
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
//Time Complexity = O(n+m)|Space Complexity = O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        int lenA=0;
        int lenB=0;
        //compute length of listA - n
        while(pointerA != null)
        {
            pointerA = pointerA.next; 
            lenA++;
        }
        //compute length of listB -m
        while(pointerB != null)
        {
            pointerB = pointerB.next; 
            lenB++;
        }
        pointerA = headA;
        pointerB = headB;
       
        while(lenA > lenB)
        {
            pointerA = pointerA.next;
            lenA--;
            
        }
        while(lenB > lenA)
        {
            pointerB = pointerB.next;
            lenB--;
        }
        //Now both are at the same length from the intersection node
        //Increment both by 1 now
        while(pointerA != null)
        {
          if(pointerA == pointerB)
               return pointerA;
           pointerA = pointerA.next;
           pointerB = pointerB.next;
          
            
        }
        return null;
    }
}