// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :GFG
// Any problem you faced while coding this :No

//we'll copy next node into current node and point current's next to next's next
class Solution {
    void deleteNode(Node del) {
        del.data = del.next.data;
        del.next = del.next.next;
        // Your code here
    }
}