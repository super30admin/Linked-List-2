// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {void} Do not return anything, modify head in-place instead.
 */
var reorderList = function(head) {
    if (!head || !head.next) return head;
    
    let slow = head;
    let fast = head.next;
    while (fast && fast.next) {
        slow = slow.next;
        fast = fast.next.next;
    }

    let secondHalf = reverseList(slow);
    slow.next = null;
    slow = head;
    fast = secondHalf;
    while (fast) {
        let temp = slow.next;
        slow.next = fast;
        fast = fast.next;
        slow.next.next = temp;
        slow = temp;
    }
};

var reverseList = function(head) {
    if (!head || !head.next) return head;
    
    let curr = head.next,
        prev = null;
    while (curr != null) {
        let temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
    }
    return prev;
}
