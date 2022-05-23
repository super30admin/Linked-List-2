class Solution {
    // Time complexity is O(1)
    // Space complexity is O(1)
    // This solution is submitted on Geeksforgeeks with no errors.
    class Node {
        int data ;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    void deleteNode(Node del) {
         del.data = del.next.data;
         del.next = del.next.next;
    }
}