// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach 
// Just change the node value to next node value. Then remove the next node by pointing to node.next.next 

/*
class Node
{
    int data ;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
*/

// Function to delete a node without any reference to head pointer.
class Solution {
    void deleteNode(Node node) {
        // Your code here
        node.data = node.next.data;
        node.next = node.next.next;
        
        //TC :- O(1)
        //SC :- O(1)
    }
}