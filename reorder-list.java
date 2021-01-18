// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// find mid of list by slow fast pointers. reverse second half of list. keep adding second half of list with first half

public void reorderList(ListNode head) {
    if(head == null || head.next == null) return;
    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null ){
        slow = slow.next;
        fast = fast.next.next;
    }
    fast = slow.next;
    slow.next = null;
    ListNode prev = null;
    while(fast != null){
        ListNode node = fast;
        fast = fast.next;
        node.next = prev;
        prev = node;
    }        
    ListNode curr = head;
    while(prev != null){
        ListNode node = prev;
        prev = prev.next;
        node.next = curr.next;
        curr.next = node;
        curr = node.next;
    }
    
    return;
}