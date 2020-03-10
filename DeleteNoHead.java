//o(1) time and space complexities
//passed in geeksforgeeks
//used approach from class

class GfG
{
    void deleteNode(Node node)
    {
        // Your code here
        node.data = node.next.data;
        node.next = node.next.next;
    }
}