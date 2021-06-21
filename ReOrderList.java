class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode slow = head;
        ListNode fast = head;
		//find mid
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //Reverse the list
        fast = reverseList(slow.next);

        //Merge the List
        slow.next = null;
        slow = head;
        while(fast!=null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }

    }

    public ListNode reverseList(ListNode head) {
        
        ListNode prev = null, cur = head, next = null;
        
        if(head == null)
            return null;
       
        while(cur.next != null){
            next = cur.next;  
            cur.next = prev;
            prev = cur;
            cur = next;
                      
        }
        cur.next = prev;
        return cur;        
    }
}