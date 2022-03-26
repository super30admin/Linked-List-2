/**
 * space complexity is O(1)
 * time complexity is O(n)
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode prev = null;
        ListNode curr = slow;
        ListNode temp = slow;
        
        while(temp != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        ListNode firstHalf = head;
        ListNode secondHalf = prev;
        
        while(secondHalf.next != null) {
            temp = firstHalf.next;
            firstHalf.next = secondHalf;
            firstHalf = temp;
            
            temp = secondHalf.next;
            secondHalf.next = firstHalf;
            secondHalf = temp;
        }
    }

    class ListNode
    {
        int data ;
        ListNode next;
        ListNode(int d)
        {
            data = d;
            next = null;
        }
    }
}