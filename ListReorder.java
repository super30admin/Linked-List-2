// Time Complexity : O(n)
// Space Complexity : O(n)
public class ListReorder {
	   
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
    
        ListNode slow =  head;
        ListNode fast =  head;
        
        while(fast!=null && fast.next!= null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        
        while (fast != null){
          ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;   
        }
    }
    
    
    private ListNode reverse (ListNode head) {
        ListNode prev = null;
        if (head == null) return null;
        ListNode fast = head.next;
        while(fast!=null){
            head.next = prev;
            prev = head;    
            head = fast;
            fast = fast.next;
        }
        head.next = prev;
        return head;
        
    }

}
