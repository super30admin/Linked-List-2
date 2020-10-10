 //Time Complexity = O(N) 
 //Space Complexity is O(1) 
  
  // merging of two linked lists is happening i.e one is head + second = dump
 class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return;
        ListNode second = splitHalf(head);
        second = reverse(second);
        ListNode dump = new ListNode(-1);
        ListNode back = dump;
        while(head != null) {
            dump.next = head;
            head = head.next;
            dump = dump.next;
            dump.next = second;
            second = second.next;
            dump = dump.next;
        }
        if(second != null) dump.next = second;
        head = back.next;
    }
    
    // splitting the entire linked list to two linked lists
    
    private ListNode splitHalf(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        ListNode pre = node;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        return slow;
    }
    
    // reversing the second linked list
    
    private ListNode reverse(ListNode node){
        ListNode pre = null;
        while(node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
