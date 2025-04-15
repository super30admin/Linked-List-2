public class deleteWithoutHeadPointer 
{
    public class Node
    {
        int data ;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    public class Solution 
    {
        void deleteNode(Node node) 
        {
            if (node == null || node.next == null) 
            {
                return;
            }
            Node nextNode = node.next;
            node.data = nextNode.data;
            node.next = nextNode.next;
        }
    }
}
