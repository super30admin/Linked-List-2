// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
Just copy data of next to curr node (Node to be deleted)
Set curr node's next pointer to the next pointer of next node.
*/

class Solution {
    public void deleteNode(ListNode node) {
        if(node == null)    return;
        
        node.val = node.next.val;
        node.next = node.next.next;
        
    }
}