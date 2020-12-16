/*
def deleteNode(curr_node):
    temp = curr_node
    temp = temp.next
    while temp.next is not None:
        curr_node.data = temp.data
        curr_node = curr_node.next
        temp = temp.next
    curr_node.data = temp.data
    curr_node.next = None
*/

// Time Complexity : O(n) where n could be linkedlist middle node and we have to update half or more than half of nodes is some cases
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: update the cur val to the next node's val and make the last node null
class Solution{
    public void deleteNode(Node node){
        Node temp = node.next;

        while (temp != null){
            node.data = temp.data;
            node = node.next;
            temp = temp.next;
        }
        node.data = temp.data;
        node.next = null;
    }
}