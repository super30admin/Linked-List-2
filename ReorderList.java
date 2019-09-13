class ReorderList {
    // Time complexity O(n)
    // Space complexity O(1)
    // Tested in Leetcode
    // # of attempt = 2 first run was compile error, next attempt - submited succesfully
  
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        
        // find node from where list will be reversed
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow.next = reverse(slow.next);
        
        ListNode front = head;
        ListNode nloc = head;
        ListNode prev = slow;
        
        while(front != prev){
            nloc = nloc.next;
            front.next = prev.next;
            prev.next = prev.next.next;
            front.next.next = nloc;
            front = nloc;
        }
    }
    
    //function to reverse list
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode nloc = head;
        
        while(curr != null){
            nloc = nloc.next;
            curr.next = prev;
            prev = curr;
            curr = nloc;
        }
        return prev;
    }  
}