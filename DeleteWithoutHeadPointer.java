class DeleteWithoutHeadPointer {
    void deleteNode(Node node) {
        if(node == null || node.next == null){
            return;
        }

        Node slow = node;
        Node fast = node.next;

        while(fast.next != null){
            slow.data = fast.data;
            slow = slow.next;
            fast = fast.next;
        }
        slow.data = fast.data;
        slow.next = null;
        // Your code here
    }
}
