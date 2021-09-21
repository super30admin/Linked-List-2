//Time complexity: O(N)
//Space complexity: O(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        
        //find middle
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse the second part
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        
        //merge the list
        ListNode tmp = null;
        while(fast != null) {
            tmp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = tmp;
            slow = tmp;
            
        }
    }
        
        public ListNode reverse(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            ListNode tmp = head.next;
            while(tmp != null) {
                curr.next = prev;
                prev = curr;
                curr = tmp;
                tmp = tmp.next;
            }
            curr.next = prev;
            return curr;    
        }
    
    
    
}