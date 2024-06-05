//time O(1)
//space O(1)

class Solution
{
    void deleteNode(Node del_node)
    {
         // Your code here
         
         Node temp = del_node.next;
         del_node.data = temp.data;
         del_node.next = del_node.next.next;
         temp = null;
    }
}
