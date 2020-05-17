// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Sample {

    class Node
    {
        int data ;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    // Time Complexity : O(1)
    // Space Complexity : O(1)
    // Did this code successfully run on GFG : Yes
    // Any problem you faced while coding this : No


    // Problem 3
    /**
     * 1. Since the node is not last element in the list, we can copy the next node's data into this node.
     * 2. Then point its next as next node's next.
     */
    void deleteNode(Node node)
    {
         // Your code here
         node.data = node.next.data;
         node.next = node.next.next;
         return;
    }
}