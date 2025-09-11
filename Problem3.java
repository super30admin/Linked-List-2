// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Since we are given the head node we do not know the prev node to delete node hence we copy the data of next to delete node to delete node and then skip the duplicate node
class Solution {
    public void deleteNode(Node del_node) {
        // code here
        if (del_node == null || del_node.next == null) return;
        //copy the data of next to delete node to delete node
        del_node.data = del_node.next.data;
        del_node.next = del_node.next.next; //skip the dup node
        
    }
    

}
