// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on LeetCode : Yes 

// approach:
// 1) Copy next node’s data into current node.
// 2) Point current.next to next.next.
// 3) Edge case: if node is tail, do nothing.


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteWithoutHeadPointer {
    public void deleteNode(Node del) {
        if (del == null || del.next == null) {
            return;
        }

        del.data = del.next.data;
        del.next = del.next.next;
    }
}
