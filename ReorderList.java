class Solution {
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        
        ListNode mid = findMid(head);
        ListNode reverse = reverseList(mid.next);
        mid.next = null;
       
        ListNode fast = reverse;
        ListNode slow = head;
        
        while(fast != null){
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }
    
    private ListNode findMid(ListNode head){
        ListNode first = head;
        ListNode second = head;
        
        while(first != null && first.next != null){
            second = second.next;
            first = first.next.next;
        }
        return second;
    }
    
    private ListNode reverseList(ListNode head){
        ListNode temp = null, prev = null;
        ListNode curr = head;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}

Time Complexity: O(n)
Space Complexity: O(1)