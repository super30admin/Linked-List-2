// 160. Intersection of Two Linked Lists

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
        
        int lenA = 0;
        int lenB = 0;
        
        ListNode curr = headA;
  
        while(curr != null){
            curr = curr.next;
            lenA++;
        }
        curr = headB;
 
        while(curr != null){
            curr = curr.next;
            lenB++;
            }
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA){
            headB = headB.next;;
            lenB--;
        }
        
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
        
    }
}


/*
Complexity Analysis

Let N be the length of list A and M be the length of list B.

Time complexity : O(N+M).
In the worst case, each list is traversed twice giving 
(2*M)+(2*N), which is equivalent to O(N+M).

Space complexity : 
O(1).
*/