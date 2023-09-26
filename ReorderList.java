// Time Complexity :O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Find the mid node of the linkedlist and reverse the second part of the linkedlist
 * Change the nodes simultaneously such that nodes are placed alternatively from both the linkedlists
 * Use 4 ptrs and change the links accordingly
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode first = head;
        ListNode second = reverse(mid);
        ListNode curr1 = first;
        ListNode curr2 = second;
        while(first!=null && second!=null){
            curr1 = first.next;
            first.next = second;
            first = curr1;
            curr2 = second.next;
            second.next = first;
            second = curr2;
        }
              
    }
    ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr= head;
        ListNode next = head;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

}