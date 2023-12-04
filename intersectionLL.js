// Problem4 (https://leetcode.com/problems/intersection-of-two-linked-lists/)
//Accepted in Leetcode
//TC is (m+n) and SC is O(1)

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

    // length of lists

    let countA = 0;
    let countB = 0;

    let curr = headA;

    while(curr!= null){
        curr = curr.next;
        countA++;
    }

    curr= headB;

    while(curr!= null){
        curr = curr.next;
        countB++;
    }

    // check and move the pointer

    while(countA>countB){
        headA = headA.next;
        countA--;
    }   

    while(countB>countA){
        headB = headB.next;
        countB--;
    }

    //find the intersection

    while(headA != headB){

        headA = headA.next;
        headB = headB.next;
    }

    return headA;
}; 