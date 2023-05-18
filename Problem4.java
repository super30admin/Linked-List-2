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
//  Time: O(n) n +n in worst case
// Space: O(1)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode a = headA;
        ListNode b = headB;
        if(headA == null || headB == null) return null;
        while(a!=b){
            a = a==null? headB : a.next;
            b = b == null ? headB : b.next;
        }
        return a;
    }
}