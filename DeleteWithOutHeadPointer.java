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
  class DeleteWithOutHeadPointer {
    void deleteNode(Node node) {
        if(node == null)
            return;
        if(node.next == null)
            return;
        
        node.data = node.next.data;
        node.next = node.next.next;
        }
    } 
