// ## Problem2 (https://leetcode.com/problems/reorder-list/)

// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :    slow.next.next = front had doubts where will this condition might give null pointer error
function reverseList(current){
    // Time Complexity : O(N)
// Space Complexity : O(1)
    prev = null
    while(current){
        let front = current.next
        current.next = prev
        prev = current
        current = front
    }
    return prev
}
var reorderList = function(head) {
      //Half Reverse the linked list
      let slow = head
      let fast = head
      while(fast.next && fast.next.next){
        slow = slow.next
        fast = fast.next.next
      }
      fast=reverseList(slow.next)
      slow.next = null
      slow = head
      //Slow is pointing at the first ele
      //Fast is pointing to the last ele
      while(fast!=null){
        let front = slow.next
        slow.next = fast
        fast = fast.next
        slow.next.next = front
        slow = front
      }
      // merge
};