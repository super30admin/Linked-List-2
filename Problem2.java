class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }

        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversehead = reverse(slow.next);
        slow.next = null;
       
        fast = reversehead;
     
        slow = head;
       

        while(fast!=null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next=temp;
            slow = temp;
        }

        
    }

    private ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
