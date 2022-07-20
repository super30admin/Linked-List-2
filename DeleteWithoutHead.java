// Time Complexity : O(1) No iteration
// Space Complexity : O(1) No extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

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

//Function to delete a node without any reference to head pointer.
class DeleteWithoutHead
{
    void deleteNode(Node del)
    {
        // Your code here
        del.data = del.next.data;
        del.next = del.next.next;
    }
}