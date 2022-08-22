// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
We override the given node's value with it's next node value and we change the next of this node to node.next.next
*/
public class DeleteWithoutHead {
    class Node {
        int data;
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
