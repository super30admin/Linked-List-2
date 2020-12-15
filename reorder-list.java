// Time - O(N)
// Space - O(1)
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        
        ListNode slow = head, fast = head;
        
         while(fast.next != null && fast.next.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        
        while(fast != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    
    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, curr = head;
        while(curr!=null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
