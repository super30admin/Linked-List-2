// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Reverse linked list from the middle
var reverse = function(head) {
    let pre = head;
    let curr = head.next;
    pre.next = null;
    while(curr !== null) {
        let next = curr.next;
        curr.next = pre;
        pre = curr;
        curr = next;
    }
    return pre;
}

var reorderList = function(head) {
    let slow = head;
    let fast = head;
    if(head === null || head.next === null) return;
    
    // Travel mid of linked list
    while(fast.next !== null && fast.next.next !== null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    
    // Reverse linked list from the middle
    fast = reverse(slow.next);
    slow.next = null;
    slow = head
    
    // Merge two linked list
    while(fast != null) {
        let temp = slow.next
        slow.next = fast;
        fast = fast.next;
        slow.next.next = temp;
        slow = temp;
    }
    return 
};