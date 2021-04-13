/*

Thought Process: Initially, find the mid element, disconnect the two parts. Reverse the second part and finally merge both the parts

T.C -> O(N) -> 2 Pass Solution
S.C -> O(1) -> Pointer approach solution

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        
        ListNode slow = head, fast = head;
        // Mistake Commited -> Used || instead of &&
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondList = slow.next;
        slow.next = null;
        // Mistake Commited -> Edge Case not checked for LL with size 1 where we don't reverse the second part as it is null
        if(secondList == null) return;
        ListNode reversedSecondList = reverseLL(secondList);
        ListNode p1 = head, p2 = reversedSecondList;
        // Mistake Commited -> Initialized next = head and made change to it after p1=next as next = p1.next
        while(p2!=null){
            ListNode next = p1.next;
            p1.next = p2;
            p2 = p2.next;
            p1.next.next = next;
            p1 = next;
        }
    }
    
    public ListNode reverseLL(ListNode curr){
        ListNode prev = null, next = curr.next;
        while(next != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;
        }
        curr.next = prev;
        return curr;
    }
}