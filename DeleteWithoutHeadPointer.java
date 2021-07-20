//TimeComplexity:O(1)
//Space Complexity: O(1)
//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node del)
    {
        del.data = del.next.data;
        del.next = del.next.next;
    }
}

