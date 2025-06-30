//Copy the next node's value into the current and bypass the next node.
//Alter the value of the current node (not true deletion). 
//Can’t be used when duplicates or references to original data matter.
// Time Complexity: O(1)
// Space Complexity: O(1)

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
            // Cannot delete the node if it's the last node
            return;
        }
        del.data = del.next.data;
        del.next = del.next.next;
    }
}
