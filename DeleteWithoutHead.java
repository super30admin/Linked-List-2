/**
 * class Node
 * {
 * int data ;
 * Node next;
 * Node(int d)
 * {
 * data = d;
 * next = null;
 * }
 * }
 */

//Function to delete a node without any reference to head pointer.
// Copy data from next node and skip that node
class Solution {
    void deleteNode(Node del) {
        del.data = del.next.data;
        del.next = del.next.next;
    }
}