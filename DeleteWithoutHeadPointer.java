// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes (on G4G). Leet code also has the same problem (Problem 237) 
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach:
// WE just copy the value of the next node to the given node and then move node to next.next

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class DeleteWithoutHeadPointer {

    // Function to delete a node without any reference to head pointer.

    void deleteNode(Node del) {
        // Your code here
        del.data = del.next.data;
        del.next = del.next.next;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(4);
        head.next.next.next = new Node(30);
        head.next.next.next.next = new Node(40);

        Node nodeToDelete = head.next.next; // Node to delete: 4

        DeleteWithoutHeadPointer obj = new DeleteWithoutHeadPointer();
        obj.deleteNode(nodeToDelete);

        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }
}
