// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (237): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}