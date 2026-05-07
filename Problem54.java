// Time Complexity : O(1)
// Space Complexity : O(1)

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public void deleteNode(Node del) {
        if (del == null || del.next == null) {
            return;
        }

        del.data = del.next.data;
        del.next = del.next.next;
    }
}