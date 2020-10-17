class Deletewithoutheadpointer
{
    // Time complexity O(1)
    // Space complexity O(1)
    // Tested , # of attemp =1
    void deleteNode(Node node)
    {
        if(node == null)
            return;
        else if(node.next == null)
            node = null;
        else if(node.next.next == null){
            node.data = node.next.data;
            node.next = null;
        }
        else{
            node.data = node.next.data;
            node.next = node.next.next;
        } 
    }
}