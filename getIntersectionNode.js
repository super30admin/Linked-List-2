// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

var getIntersectionNode = function(headA, headB) {
    
    // Get the length of A
    let lengthA = 0;
    let curr = headA;
    while(curr != null) {
        lengthA++;
        curr = curr.next;
    }
    
    // get the length of B
    let lengthB = 0;
    curr = headB;
    while(curr != null) {
        lengthB++;
        curr = curr.next;
    }
    // Move head A to make the length equal with B
    while(lengthA > lengthB) {
        headA = headA.next;
        lengthA--;
    }
    
    // Move head B to make the length equal with A
    while(lengthA < lengthB) {
        headB = headB.next;
        lengthB--;
    }
    
    //Check if node A is equal to node B
    while(headA != headB) {
        headA = headA.next;
        headB = headB.next;
    }
    return headA;
};