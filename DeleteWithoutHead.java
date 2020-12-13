// This function should delete node from linked list. The function
// may assume that node exists in linked list and is not last node
// node: reference to the node which is to be deleted
// TC O(1) SC O(1)
class GfG
{
    void deleteNode(Node node)
    {
         int temp = node.data;
         node.data = node.next.data;
         node.next.data = temp;
         node.next = node.next.next;
    }
}
