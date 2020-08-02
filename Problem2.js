//Reorder List (LC 143)
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Reorder linked list by doing three things: find middle of linked list, reverse linked list, merge two sorted linked lists

// Your code here along with comments explaining your approach

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
var reorderList = function(head) {
    if(head === null){
        return;
    }
    let slow = head;
    let fast = head;
    while(fast !== null && fast.next !== null){
        slow = slow.next;
        fast = fast.next.next;
    }
    let prev = null;
    let current = slow;
    let temp;
    while(current){
        temp = current.next;
        current.next = prev;
        prev = current;
        current = temp;
    }
    
    let first = head;
    let second = prev;
    while(second.next !== null){
        temp = first.next;
        first.next = second;
        first = temp;
        
        temp = second.next;
        second.next = first;
        second = temp;
    }
};