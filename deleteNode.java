// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * 1. Copy the value of next node to the current node.
 * 2. Delete the next node.
 * 3. Link the current node to the next of next node.
 */

class Solution{
    void deleteNode(ListNode del){
        del.val = del.next.val;
        ListNode tmp = del.next;
        del.next = del.next.next;
        tmp.next = null;
    }
}