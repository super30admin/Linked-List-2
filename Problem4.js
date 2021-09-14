// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

var getIntersectionNode = function (headA, headB) {
    let current = headA;
    let lenA = 0;
    while (current) {
        current = current.next;
        lenA++;
    }
    current = headB;
    let lenB = 0;
    while (current) {
        current = current.next;
        lenB++;
    }

    while (lenA > lenB) {
        headA = headA.next;
        lenA--;
    }
    while (lenB > lenA) {
        headB = headB.next;
        lenB--;
    }
    while (headA != headB) {
        headA = headA.next;
        headB = headB.next;
    }
    return headA;
};