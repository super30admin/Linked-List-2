// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I set slow = node to be deleted and fast = next node. I assign the data of fast to slow. I then make slow to point to fast.next.
*/

/* Structure of linked list Node
class Node {
    public int data;
    public Node next;

    public Node(int x) {
        data = x;
        next = null;
    }
}
*/
class Solution
{
    public void deleteNode(Node del_node)
    {
        // code here
        Node slow = del_node;
        Node fast = del_node.next;

        slow.data = fast.data;
        slow.next = fast.next;
        fast = null;
    }
}