/*
Time Complexity: O(n) where n is the number of nodes in the linked list.
Space Complexity: O(1) since we are not using any extra space except for a few variables. 
Did this code successfully run on GFG : Yes
Any problem you faced while coding this : No
Intuition: The idea is to copy the data from the next node into the 
current node and then skip the next node.

*/
public class DeleteWithoutHead {

    void deleteNode(Node node) {
        Node temp = node;
        temp = temp.next;
        node.data = temp.data;
        node.next = temp.next;
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
