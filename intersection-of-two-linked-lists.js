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
 * @param {ListNode} headA
 * @param {ListNode} headB
 * @return {ListNode}
 */
var getIntersectionNode = function(headA, headB) {
    if (!headA || !headB) return null;
    
    let tempA = headA,
        tempB = headB;
    while (tempA != tempB) {
        tempA = tempA.next;
        tempB = tempB.next;
        
        if (!tempA && !tempB) return tempA;
        if (!tempA) tempA = headB;
        if (!tempB) tempB = headA;
    }
    return tempA;
};
