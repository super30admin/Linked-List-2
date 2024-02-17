// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// As there is no way to delete the actual pointer at del; we copy
// elements from the next pointer and point the last to null

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class DeletionAtNode {
    void deleteNode(Node del) {
        // Your code here
        // del is never a tail pointer
        while (del.next.next != null) {
            del.data = del.next.data;
            del = del.next;
        }

        // will come out at second last element
        // copy the last element and point del to null
        del.data = del.next.data;
        del.next = null;
    }
}