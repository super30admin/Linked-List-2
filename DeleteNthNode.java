//To delete without head pointer, we just copy the data from next node to current node and move the next pointer to next.next.
//Time Complexity: O(1)
//Space Complexity: O(1)

class Solution {
    public void deleteNode(Node del_node) {
        // code here
        if (del_node == null || del_node.next == null) {
            return;
        }
        
        del_node.data = del_node.next.data;
        del_node.next = del_node.next.next;
    }
}