// ## Problem2 (https://leetcode.com/problems/reorder-list/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

var reorderList = function(head) {
    if (!head || !head.next || !head.next.next) return head;
  
    // step 1: use fast and slow pointer to move to the middle of linked list
    // in case list is even, then move to the middle left node
    let fast = head.next, slow = head;
    while (fast && fast.next) {
      fast = fast.next.next;
      slow = slow.next;
    }
  
    // get the second half of list
    const secondHalf = slow.next;
  
    // break the list
    slow.next = null;
  
    // step 2: reverse the second half
    let curr = secondHalf, prev = null, tmp;
  
    while (curr) {
      tmp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = tmp;
    }
  
    // step 3: interleave the first half with second half
    let first = head, second = prev;
    while (second) {
      tmp = first.next;
      first.next = second;
      second = second.next;
      first.next.next = tmp;
      first = tmp;
    }
  };