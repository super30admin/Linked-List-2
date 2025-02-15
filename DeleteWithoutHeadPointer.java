
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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


// Function to delete a node without any reference to head pointer.
class DeleteWithoutHeadPointer {
    void deleteNode(Node node) {
        // Your code here

        if(node == null || node.next == null) {
            return;
        }

        node.data = node.next.data;
        node.next = node.next.next;
    }
}
