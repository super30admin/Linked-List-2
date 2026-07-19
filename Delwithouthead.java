// Time Complexity : O(1)
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// We are given a node to be deleted and we have to delete that node without head pointer.
//  So we will copy the next node's data into current node and then skip the next node by pointing current node's next to next of next node. 
// This way we are able to delete the node without head pointer.
class Node {
    public int data;
    public Node next;

    public Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {
    public void deleteNode(Node del_node) {

        // copy next node’s data into current node
        del_node.data = del_node.next.data;

        // skip next node
        del_node.next = del_node.next.next;
    }
}