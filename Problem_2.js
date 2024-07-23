// Leetcode: https://leetcode.com/problems/reorder-list/
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Idea behind this solution is to divide the list into two halves and then reverse the second half. 
// Once second half is reversed, we merge the first and second half to get complete re-ordered list.
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {void} Do not return anything, modify head in-place instead.
 */
var reorderList = function (head) {
    // find middle
    let slow = head;
    let fast = head;
    while(fast.next!=null && fast.next.next!=null){
        slow = slow.next;
        fast = fast.next.next;
    }
    //reverse second half
    fast = reverseList(slow.next);
    slow.next = null;
    slow = head;

    //merge the two parts of original list (i.e. no extra space)
    while(fast!=null){
        if(slow!=null){
            var tmp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = tmp; 
            slow = tmp;
        }
    }   
};

const reverseList = (node) =>  {
    if(node == null || node.next == null) return node;
    let prev = null;
    let curr = node;
    let next = node.next;

    while(next!= null){
        curr.next = prev;
        prev = curr;
        curr = next;
        next = next.next;
    }
    curr.next = prev;

    return curr;
}