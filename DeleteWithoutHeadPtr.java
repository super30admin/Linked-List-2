/**
 * Time complexity: O(1)
 * Space complexity: O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : no
 *
 * Approach:
 * Replace the value of node with its next node's value
 */
public class DeleteWithoutHeadPtr {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void deleteNode(Node node) {
        // Your code here
        if (node == null) {
            return;
        }

        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;
        Node n3 = new Node(3);
        n2.next = n3;
        n3.next = new Node(4);

        DeleteWithoutHeadPtr obj = new DeleteWithoutHeadPtr();
        obj.deleteNode(n2);

        Node curr = n1;
        while(curr != null) {
            System.out.println(curr.data + "->");
            curr = curr.next;
        }
    }
}
