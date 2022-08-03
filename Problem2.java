//Time Complexity: O(n)
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem2 {

    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null || head.next.next == null)
            return;
        
        ListNode slow = head;
        ListNode fast = head;
        
        //find middle
        
        while(fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
    
        //reverse 2nd half of LL
        
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        
        //reorder
        
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
