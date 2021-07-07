class Solution
{
    // Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this :

/*
1. Update the node value which is to be deleted to next node value.
2.Then move the node pointer to next.next
3. Assuming the node to be deleted is not last node.
*/
    void deleteNode(Node node)
    {

        if(node.next.next != null) {
         Node temp = node.next;
         node.data = temp.data; 
         node.next = node.next.next; 
        }
        else if(node.next != null) {
            Node temp = node.next;
            node.data = temp.data;
            node.next = null;
        }
    }
}