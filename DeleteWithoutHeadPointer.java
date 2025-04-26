// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Copy the data from the next node into the current node.
//   - Bypass the next node by linking to next.next.
//   - Set the next pointer of the removed node to null to avoid memory leaks.

class Node
{
    int data ;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}

public class DeleteWithoutHeadPointer {
    void deleteNode(Node node) {
        // Your code here
        node.data = node.next.data;
        Node temp = node.next;
        node.next = node.next.next;
        temp.next = null;
    }

    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // Linked list: 1 -> 2 -> 3 -> 4
        Node head = new Node(1);
        head.next = new Node(2);
        Node nodeToDelete = new Node(3);
        head.next.next = nodeToDelete;
        head.next.next.next = new Node(4);

        System.out.print("Original list: ");
        printList(head);

        DeleteWithoutHeadPointer solution = new DeleteWithoutHeadPointer();
        solution.deleteNode(nodeToDelete);

        System.out.print("After deletion: ");
        printList(head);
    }
}
