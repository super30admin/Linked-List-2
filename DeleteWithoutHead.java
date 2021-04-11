// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes on geeksforgeeks
// Any problem you faced while coding this : no

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
public class DeleteWithoutHead {

        void deleteNode(Node node)
        {
            // Your code here
            node.data = node.next.data;
            node.next = node.next.next;
        }

}
