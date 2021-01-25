// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

public class DeleteWithoutHeadPointer {
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

    // This function should delete node from linked list. The function
// may assume that node exists in linked list and is not last node
// node: reference to the node which is to be deleted
    class GfG
    {
        void deleteNode(Node node) {
            //return when node is equals to null or it is the last node
            if(node == null || node.next == null) return;

            //set the data to point to the next node
            //set the next pointer to point to 2 nodes out
            node.data = node.next.data;
            node.next = node.next.next;

        }
    }
}
