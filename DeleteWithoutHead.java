// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Function to delete a node without any reference to head pointer.
class Solution {
    void deleteNode(Node del) {

        // overrite the value
        del.data = del.next.data;

        // Connect with proper next node
        del.next = del.next.next;
    }
}