// Time Complexity : O(M+N)
//Space Complexity : O(1) 
//Did this code successfully run on Leetcode : Yes
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null ){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverse(slow.next);
        
        slow.next = null;
        slow = head;
        ListNode curr;
        while(fast != null){
            curr = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = curr;
            slow = curr;
        }
        
        
        }
    
    private ListNode reverse(ListNode head){
            ListNode prev = null;
        ListNode curr = head;
        ListNode fast = curr.next;
        
        while(fast != null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        
        curr.next = prev;
        return curr;
    }
    }