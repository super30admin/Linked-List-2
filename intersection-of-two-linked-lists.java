// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// change value to list A by multiplying it with -1. check for forst negative node in List B.
// change all nodes back to original value before returnibng answer.

public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode node = headA;
    while(node != null){
        node.val *= -1;
        node = node.next;
    }
    while(headB != null && headB.val > 0){
        headB = headB.next;
    }
    while(headA != null){
        headA.val *= -1;
        headA = headA.next;
    }
    return headB;
}