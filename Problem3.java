// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
I copied the values from the node next to del_node.
Once I copied I pointed the curr_node to next of next
*/


import org.w3c.dom.Node;

public class Problem3 {
    public void deleteNode(Node del_node) {
        // code here
        Node next_node = del_node.next;
        del_node.data = next_node.data;
        del_node.next = next_node.next;
    }
}
