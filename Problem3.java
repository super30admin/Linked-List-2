// TC: O(1)
// SC: O(1) 
class Solution {
    void deleteNode(Node node) {
        // Your code here
        
        if(node == null || node.next == null)return;
        
        Node nextNode = node.next;
        node.data = nextNode.data;
        node.next = nextNode.next;
    }
}