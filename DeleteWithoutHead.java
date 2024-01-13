/*
* Approach:
*  1. Copy the next node value into curr node
* 
*  2. Remove the next node
* 
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(1)
* 
* Space Complexity: O(1)
* 
*/

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class DeleteWithoutHead {
    void deleteNode(Node del) {
        // Your code here
        Node prev = del, curr = prev.next;

        prev.data = curr.data;

        Node temp = curr;

        prev.next = curr.next;

        temp.next = null;
    }
}
