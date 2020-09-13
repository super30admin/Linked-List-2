Time Complexity: O(n)
Space Complexity: O(1)
Ran successfully on leetcode?: yes

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode head2 = null;
        ListNode result = new ListNode();
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        
        head2 = reverseList(slow.next);
        slow.next = null;
        
        ListNode currHead1 = head;
        ListNode currHead2 = head2;
        ListNode next1;
        ListNode next2;
        while(currHead1 != null && currHead2 != null){
            next1 = currHead1.next;
            next2 = currHead2.next;
            currHead1.next = currHead2;
            currHead2.next = next1;
            currHead1 = next1;
            currHead2 = next2;
        }
        return;
    }
    
    private ListNode reverseList(ListNode slowNext){
        //reverse the second half
        ListNode prev = null;
        ListNode curr = slowNext;
        
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
