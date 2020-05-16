// ## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :

const getIntersectionNode = function(headA, headB) {
    if(!headA || !headB) return null;
    let cur = headA;
    let lenA = 0; let lenB = 0;
    while(cur !== null) {
        lenA++;
        cur = cur.next;
    }
    cur = headB;
    while(cur !== null) {
        lenB++;
        cur = cur.next;
    }
    while(lenA > lenB) {
        headA = headA.next;
        lenA--;
    }
    while(lenB > lenA) {
        headB = headB.next;
        lenB--;
    }
    while(true) {
        if(headA === headB) return headA;
        headA = headA.next;
        headB = headB.next;       
    }   
};