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
*/
// The time complexity is O(N) and the space complexity is O(1).
// Here the each node data is replaced by node.next data and the last node is removed from the list.
// Yes, the solution passed all the test cases in geeksforgeeks
// This function should delete node from linked list. The function
// may assume that node exists in linked list and is not last node
// node: reference to the node which is to be deleted
class GfG
{
    void deleteNode(Node node)
    {
        Node prev;
        while(node.next!=null){
            node.data = node.next.data;
            prev = node;
            node = node.next;
        }

        prev.next = null;
    }
}
