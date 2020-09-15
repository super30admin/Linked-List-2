//Time :O(1)
//Space: O(1)
class GfG {
    void deleteNode(Node node) {
        // Your code here

        node.data = node.next.data;
        node.next = node.next.next;

    }
}