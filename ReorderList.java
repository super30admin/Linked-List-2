//Time Complexity: O(n) 
//Space complexity: O(1)

public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return ;
        ListNode res;
        ListNode fast = head; 
        ListNode slow = head; 
        // diving the linked using 2 pointer approach
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = slow.next;

        //reversing the second half
        ListNode prev=null;
        slow.next=null;
        while(fast != null){
           ListNode next=fast.next;
           fast.next=prev;
           prev=fast;
           fast=next;
        }
        fast=prev;

        //merging the two head of slow and fast
        while(head!=null && fast!=null){
           res=head.next;
           head.next=fast;
           fast=fast.next;
           head.next.next=res;
           head=res;
       }                
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}