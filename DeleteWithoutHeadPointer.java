//TC - O(1), SC - O(1)

public class DeleteWithoutHeadPointer {

    void deleteNode(Node del_node)
    {
        del_node.data = del_node.next.data;
        del_node.next = del_node.next.next;
    }

    static class Node
    {
        int data ;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
}
