// Time complexity - O(m+n)
// Space complexity - O(1)

// Calculate length of both lists. Move head of longer list by difference betwen length of lists.

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
        ListNode curr = headA;
        int lenA = 0;
        int lenB = 0;
        while(curr != null){
            lenA++;
            curr = curr.next;
        }
        curr = headB;
        while(curr != null){
            lenB++;
            curr = curr.next;
        }
        
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        
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
