// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

import org.w3c.dom.Node;

public class Problem3 {
    void deleteNode(Node node) {
        Node temp = node;
        temp=temp.next;
        node.data=temp.data;
        node.next=temp.next;
    }
}
