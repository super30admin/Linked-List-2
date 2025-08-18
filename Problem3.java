// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public void deleteNode(Node del_node) {
        // code here
        del_node.data=del_node.next.data;
        del_node.next=del_node.next.next;
    }
}