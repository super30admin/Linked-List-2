class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        // Finding middle of list
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=slow.next;
        
        //Reversing the end of list
        slow.next=null;
        ListNode prev = null;
        while(fast!=null){
            ListNode next = fast.next;
            fast.next=prev;
            prev=fast;
            fast=next;
        }
        // Fast is at the head of reverse list;
        fast=prev;;
        
        // Reordering the list
        ListNode next;
        while(head!=null && fast!=null){
            next=head.next;
            head.next=fast;
            fast=fast.next;
            head.next.next=next;
            head=next;
        }
        
    }
}