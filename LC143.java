class Solution {
    public void reorderList(ListNode head) {
        
        if(head == null){
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode h2 = reverse(slow.next);
        slow.next = null;
        
        ListNode h1 = head;
        
        ListNode temp1;
        ListNode temp2;
        
        while(h2 != null){
            temp1 = h1.next;
            h1.next = h2;
            temp2 = h2.next;
            h2.next = temp1;
            h1 = temp1;
            h2 = temp2;
        }
    }
    
    private ListNode reverse(ListNode curr){
        ListNode prev = null;
        ListNode temp = null;
        
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev;
    }
}

//Time complexity: O(n)
//Space Complexity:O(1)
