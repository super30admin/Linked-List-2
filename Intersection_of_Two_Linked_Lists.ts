/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function getIntersectionNode(headA: ListNode | null, headB: ListNode | null): ListNode | null {

    // brute force - write in a hashset for longest list and then check small list occurence
    // return the value when value is found
    // let setA = new Set();

    // while(headA !== null) {
    //     setA.add(headA);
    //     headA = headA.next;
    // }

    // while(headB !== null) {
    //     if (setA.has(headB)){
    //     return headB;
    //     }
    //     headB = headB.next;
    // }

    // return null;

    // get how much to skip for a pointer with long list
    // skip that many and apply the pointer
    // increment pointer unit both pointers are not equal

    let countA: number = 0;
    let countB: number = 0;
    let currA = headA;
    let currB = headB;

    while (currA !== null) {
        countA++;
        currA = currA.next;
    }

    while (currB !== null) {
        countB++;
        currB = currB.next;
    }

    currA = headA;
    currB = headB;

    while (currA !== null && countA > countB) {
        currA = currA.next;
        countA--;
    }

    while(currB !== null && countB > countA) {
        currB = currB.next;
        countB--;
    }

   
    while (currA !== currB ) {
        currA = currA.next;
        currB = currB.next;
    } 
    
    return currA
};