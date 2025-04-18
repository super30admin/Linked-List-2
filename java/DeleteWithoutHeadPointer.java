package java;

public class DeleteWithoutHeadPointer {
    // Function to delete a node without any reference to head pointer.
    public void deleteNode(Node node) {
        Node tmp = node.next;
        node.data = tmp.data;
        node.next = tmp.next;
        tmp.next = null;
    }
}

//TC: O(1), SC: O(1)

