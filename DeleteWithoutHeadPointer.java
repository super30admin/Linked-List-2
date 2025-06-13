// Time Complexity : O(1)
// Space Complexity : O(1) — no extra space used
// Did this code successfully run on Geeks for geeks : Yes
// Any problem you faced while coding this : No


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
class DeleteWithoutHeadPointer {
    Node llNode;
    
    void deleteNode(Node node) {
        // Your code here
        
        if (node == null || node.next == null) return;
        
        Node nxtNode = node.next;
        node.data = nxtNode.data;
        
        node.next = nxtNode.next;
        
    }
}