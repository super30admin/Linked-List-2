class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public void deleteNode(ListNode node) {
        // Altough we dont know the header,
        // we could implement the operations by 
        // changing the values.
        while(node != null && node.next != null && node.next.next != null){
            ListNode new_node = node.next;
            node.val = new_node.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
        return;
    }
}