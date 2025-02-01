// TC: O(N)
// SC: O(1)
// where N is the length of the linked list

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class DeleteWithoutHeadPointer {
    void deleteNode(Node node) {
        if(node == null) return;
        Node curr = node;
        Node prev = null;
        while(curr.next!=null){
            curr.data = curr.next.data;
            prev = curr;
            curr = curr.next;
        }
        if(prev!=null) prev.next = null;
    }
}
