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

// Function to delete a node without any reference to head pointer.
class DeleteWithoutHeadPointer {
    void deleteNode(Node node) {
        if(node==null)return;
        Node temp = node.next;
        node.data=temp.data;
        if(node.next!=null)
            node.next=temp.next;
        else
            node.next=null;
    }
}

//TC: O(1);
//SC: O(1);
