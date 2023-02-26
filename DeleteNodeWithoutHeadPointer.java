class Solution
{
    void deleteNode(Node n)
    {
        // Your code here
        n.data = n.next.data;
        n.next = n.next.next;
    }
}