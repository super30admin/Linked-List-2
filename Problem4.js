//Intersection of Two Linked Lists (LC 160)
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Move pointers to see which on is shorter and then run through till you get a match

// Your code here along with comments explaining your approach

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
var getIntersectionNode = function(headA, headB) {
    if(headA === null || headB === null){
        return null;
    }
    let pointerA = headA;
    let pointerB = headB;
    
    while(pointerA !== pointerB){
        if(pointerA === null){
            pointerA = headB;          
        } else {
            pointerA = pointerA.next;
        }
        if(pointerB === null){
            pointerB = headA;          
        } else {
            pointerB = pointerB.next;
        }
    }
    return pointerA;
};