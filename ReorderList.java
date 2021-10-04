class ReorderList {
    
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    
    // Middle point -> reverse -> combine
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Reaching the mid point of linkedlist
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Split the list
        fast = reverse(slow.next);         // Reverse the Linked List from the mid-point
        slow.next = null;
        
        // Combining List
        slow = head;
        while(slow != null && fast != null){
            ListNode nextS = slow.next;
            ListNode nextF = fast.next;
            
            slow.next = fast;
            fast.next = nextS;
            
            slow = nextS;
            fast = nextF;
        }        
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}