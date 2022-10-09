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

//Time Complexity: O(n).
//Space Complexity: O(1).
//This problem can be solved using different approaches, this approach reduces the extra space required. 

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        ListNode curr = headA;
        int lenA = 0;
        while(curr != null){
            curr = curr.next;
            lenA ++;
        }
        
        curr = headB;
        int lenB = 0;
        while(curr != null){
            curr = curr.next;
            lenB ++;
        }
        
        while(lenA > lenB){
            headA = headA.next;
            lenA --;
        }
        
        System.out.println(headA.val);
        
        while(lenB > lenA){
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