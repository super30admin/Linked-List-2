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
        int l1 = 0;
        ListNode temp_a = headA;
        while(temp_a != null){
            temp_a = temp_a.next;
            l1++;
        }
        
        int l2 = 0;
        ListNode temp_b = headB;
        while(temp_b != null){
            temp_b = temp_b.next;
            l2++;
        }
        
        int diff = Math.abs(l1 - l2);
        int counter = 1;
        ListNode first = l1 > l2 ? headA : headB;
        ListNode second = first == headA ? headB : headA;
        while(counter <= diff){
            first = first.next;
            counter++;
        }
        
        while(first!=second){
            first = first.next;
            second = second.next;
        }
        
        return first;  
    }
}
