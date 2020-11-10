// Time Complexity : O(m+n)
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
    let curr = headA
    let lenA = 0
    while(curr != null){
        curr = curr.next;
        lenA++
    }
    curr = headB
    let lenB = 0
    while(curr != null){
        curr = curr.next;
        lenB++
    }
    while(lenA < lenB){
        headB = headB.next;
        lenB--
    }
    while(lenB < lenA){
        headA = headA.next;
        lenA--;
    }
    while(headA != headB){
        headA = headA.next;
        headB = headB.next
    }
    return headA
    
};