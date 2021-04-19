// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        
        //find middle
        ListNode s=head, f = head, dummy = head;
        while(f.next!= null && f.next.next!=null){
            f= f.next.next;
            s=s.next;
        }
        
        //reverse
        ListNode prev = null;
        while(s!=null){
            ListNode temp = s.next;
            s.next = prev;
            prev = s;
            s=temp;
        }
        
        s=prev;
        //merge
        while(head!=null){
            ListNode t = head.next, t1 = s.next;
            head.next = s; 
            s.next = t;
            head = t; 
            s=t1;
        }
    }
}