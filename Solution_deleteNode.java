/*
// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : All test cases had passed on Geeks for geeks.
// Any problem you faced while coding this : No

*/

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Solution_deleteNode {
    // as here we have to delete a particular node and que. has constraint that tail
    // is not a node which we have to delete.

    void deleteNode(Node del) {

        // copying next pointer of the node which we have to delete.

        Node newNode = del.next;
        // assinging the next pointer value to node which we have to delete.
        del.data = newNode.data;

        // skipping the next element.

        del.next = del.next.next;

    }
}
