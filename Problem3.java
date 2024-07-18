//Time = O(1)
//Space = O(1)

class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null; }
}

class Solution
{
    void deleteNode(Node del)
    {
        // If given node is null, just return
        if(del == null) return;
        
        // If given node is the last node, we can't delete it
        if(del.next == null) {
            return;
        }
        
        // Copy data of next node to given node
        Node nextNode = del.next;
        del.data = nextNode.data;
        
        // Update the pointers to skip the next node
        del.next = nextNode.next;
    }
}

