//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node del_node)
    {
        // Your code here
        Node temp = del_node.next;
        Node prev = del_node;
        while(temp != null) {
            prev.data = prev.next.data;
            temp = temp.next;
            if(temp != null) {
                prev = prev.next;
            }
        }
        prev.next = null;
    }
}
