// ## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)
// Function to delete a node without any reference to head pointer.

// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NONE
class Solution {
    deleteNode(node) {
        // Time Complexity : O(1)
        // Space Complexity : O(1)
        node.data = node.next.data
        node.next = node.next.next
    }
}