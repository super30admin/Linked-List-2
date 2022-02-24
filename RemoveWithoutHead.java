class LinkedList{
    Node head;
    
    LinkedList()
    {
        head = null;
    }
    
    /**
    
    TC - O(1)
    SC - O(1)
    
    **/
    // Update the value of node to be deleted with next of the node to be deleted.
    // delete the next of node that need to be deleted since we copied the value of that.
    public void deleteWhereHeadIsNotGiven(Node deleteTheNode)
    {
        deleteTheNode.val = deleteTheNode.next.val;
        deletedTheNode.next = deleteTheNode.next.next;
    }
}