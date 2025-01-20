//TC: O(N)
//SC: O(N)

class Solution {
    public void reorderList(ListNode head) {
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode newReversedList = new ListNode(0);
        
         newReversedList = reverseList(slow.next);
        slow.next = null;
        slow = head;
        fast = newReversedList;
        ListNode temp = new ListNode(0);
        while( fast!= null ){
             temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
        // return head;
        
        
    }
    
    public ListNode reverseList(ListNode head){
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