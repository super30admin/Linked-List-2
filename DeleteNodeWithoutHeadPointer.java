//TC: O(1)
//SC: O(1)
//approach: copy next node's value in delete node, and delete next node

public class DeleteNodeWithoutHeadPointer {
    void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
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
