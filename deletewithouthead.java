import org.w3c.dom.Node;

public class deletewithouthead {
// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
//approach: as we have given only tht node of which the next has to be deleted, we replace its value by its
//next value.and also points to its next node directly. so we can skip this value and node and jump to its next node.

// Your code here along with comments explaining your approach
// Function to delete a node without any reference to head pointer.
class Solution {
    void deleteNode(Node node) {
        // Your code here
        node.data=node.next.data;
        node.next=node.next.next;
        
    }
}
}
