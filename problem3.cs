class Solution {
    public void deleteNode(Node del_node) {
        // code here
        del_node.data = del_node.next.data;
        del_node.next = del_node.next.next;
    }
}