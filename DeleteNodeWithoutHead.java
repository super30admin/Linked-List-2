class Solution {

    // Time Complexity : 0(1)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: I am storing the value of next node to my current node. Then
    //I am pointing my current's next to current's next to next.

    public void DeleteNodeWithoutHead(ListNode node) {
        node.val = node.next.val;
        node.next=node.next.next;
    }
}