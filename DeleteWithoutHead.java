// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class DeleteWithoutHead {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void deleteNode(Node del) {
        // Your code here
        // copy the data and refernece of next node to the current node and delete the
        // next node
        del.data = del.next.data;
        del.next = del.next.next;
    }

    public static void main(String args[]) {

    }
}