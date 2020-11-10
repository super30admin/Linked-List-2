// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No




var reorderList = function(head) {
    if(head == null || head.next == null) return head
    let slow = head
    let fast = head
    
    var reverse = function(head){
        let prev = null;
        let curr = head
        let fast = curr.next
        
        while(fast != null){
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        }
        curr.next = prev
        return curr
    }
    
    while(fast.next != null && fast.next.next != null){
        slow = slow.next
        fast = fast.next.next
    }
    //slow is at mid
    fast = reverse(slow.next)
    slow.next = null
    slow = head
    let curr
    while(fast != null){
        curr = slow.next
        slow.next = fast
        fast = fast.next
        slow.next.next = curr
        slow = curr
    }
    
};