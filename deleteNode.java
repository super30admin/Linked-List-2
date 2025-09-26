// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
    public void deleteNode(Node del_node) {
        if (del_node==null||del_node.next==null)return;
        del_node.data=del_node.next.data;
        del_node.next=del_node.next.next;
    }
}