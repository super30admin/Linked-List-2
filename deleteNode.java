//Time Complexity: O(1)
//space complexity O(1) no extra space used
//Did this code successfully run on GeeksforGeeks : yes
//Any problem you faced while coding this : no

/**
 * The intuition is to just mimic the deletion of a node with the given del_node reference.
 * We cannot actually delete the node since we do not have access to the head of the linked list or the previous node of the node to be deleted.
 * So we copy the data of the next node to the current node and mimic the deletion of the next node by changing the next pointer of the current node to point to the next of next node.
 */

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

class deleteNode {
    public void deleteNode(Node del_node) {
        // code here
    
         if (del_node == null || del_node.next == null) {
            // Cannot delete the node if it's the last node
            return;
        }
    
    
        del_node.data=del_node.next.data;
        Node temp=del_node.next;
        del_node.next=del_node.next.next;
        temp.next=null;
    
        return;
        
        
        
    }
}