// Time Complexity : O(1), worst case [O(n), when n = 2]
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Geeks for Geeks
// Any problem you faced while coding this :


class GfG
{
    void deleteNode(Node node)
    {
        //if node to delete is not 2nd last node
        //copy next node value to node
        //and delete the next node
        if(node.next.next != null) {
         Node temp = node.next;
         node.data = temp.data; 
         node.next = node.next.next; 
        }
        
        //if node to delete is 2nd last node
        //copy last node
        //and delete last node (set to null)
        else if(node.next != null) {
            Node temp = node.next;
            node.data = temp.data;
            node.next = null;
        }
    }
}



