// ## Problem4  (https://leetcode.com/problems/intersection-of-two-linked-lists/)

// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
var getIntersectionNode = function(headA, headB) {
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    if(!headA || !headB) return null
    //hold dummy pointer
    let p = headA
    //hold dummy pointer
    let q = headB
    //Keep checking if they are same , then STOP ,if not same regarless they meet at null
    while(p != q){
        //If null then change its head-> bigger will now traverse smaller and vice versa
        if(!q) q=headA
        else{
                    q = q.next
        }
        //If null then change its head-> bigger will now traverse smaller and vice versa

        if(!p) p=headB
        else{
                    p = p.next
        }
        //This means they have met, either null or a ele

    }
    //ret that pointer
    return q
};