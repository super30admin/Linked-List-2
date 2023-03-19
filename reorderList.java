//TC: O(n)
//SC: O(1)
class Solution {
    public void reorderList(ListNode head) {
        
        //find mid O(n/2)
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //reverse O(n/2)
        ListNode head2 = reverse(slow.next);
        slow.next = null;
        
        //merge O(n)
        ListNode curr = head;
        while(head2 != null){
            ListNode temp = curr.next;     
            curr.next = head2;
            head2 = head2.next;
            curr.next.next = temp;
            curr = temp;          
        }
        
    }
         //reverse func
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
