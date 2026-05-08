// https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on geeksforgeeks : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public void deleteNode(Node del_node) {
        // code here
        if(del_node == null || del_node == null){
            return;
        }
        
        del_node.data = del_node.next.data;
        del_node.next = del_node.next.next;
    }
}