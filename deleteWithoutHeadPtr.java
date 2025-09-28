/*
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

class Solution {
    public void deleteNode(Node del_node) {
        // code here
        del_node.data = del_node.next.data;
        Node temp = del_node.next;
        del_node.next = temp.next;
        temp.next = null;
        
    }
}