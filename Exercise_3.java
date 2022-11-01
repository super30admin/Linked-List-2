class Solution
{
    void deleteNode(Node del)
    {
        Node t = del.next;
        del.data = t.data;
        del.next = t.next;
        t.next = null;
    }
}
//tc=O(1)
//sc=O(1)
