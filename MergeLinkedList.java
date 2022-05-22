

// Time Complexity : O(n+m)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
class Solution {
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow= slow.next;
        }
        fast = reverse(slow.next);
        slow.next = null;
        slow= head;
        while(fast!=null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast =fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;
        while(next!=null){
            cur.next=prev;
            prev = cur;
            cur= next;
            next = next.next;
            
        }
        cur.next = prev;
        return cur;
    }
}
