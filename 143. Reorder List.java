class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        //Find Middle of Link List
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //Reverse second half of linked list
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        
        //Merge two linked list
        slow = head;
        ListNode temp = null;
        
        while(fast != null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        
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