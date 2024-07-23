//Leetcode : https://leetcode.com/problems/intersection-of-two-linked-lists/

// Time Complexity : O(m+n) // m is number of listA nodes and n is number of listB nodes
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// The solution is to first get the length of given lists. Then we adjust the pointer for each list 
// to a element that equates to length of shorter list. Once we have equal list lengths, we reassign 
// the pointer of each list to the next node till we either find a common node that both p1 and p2 reference
// or either one of the pointer ends in null. if the p1 and p2 pointers are equal, then we can return either of the pointer, 
// else return null since there is no interaction. 

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
    
    let aLen = 0;
    let bLen = 0;
    let p1 = headA;
    let p2 = headB;

    while(p1!= null){ // Find listA len
        p1 = p1.next;
        aLen++;
    } 

    while(p2!= null){ // Find listB len
        p2 = p2.next;
        bLen++;
    }
    p1 = headA; //rest pointers to head of the list again
    p2 = headB;

    if(aLen > bLen){ // Check which list is larger and push it's pointer to (largerLen - smallerLen)th node
        while(aLen > bLen){
            p1 = p1.next;
            aLen--;
        }
    }
    else if(bLen > aLen){
        while(bLen > aLen){
            p2 = p2.next;
            bLen--;
        }
    }

    while(p1 != p2 && p1 != null && p2!= null){ // Run iteration till intersection is found or p1 or p2 runs out of list nodes
        p1 = p1.next;
        p2 = p2.next;
    }

    if(p1==p2 && p1 != null && p2!= null) // if intersection is found, return intersection 
        return p1;

    return null;
};