// Time Complexity : O(1)
// Space Complexity : O(1)
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
As we dont have head and cant access previous node, we will shift the next node's data backward and
delete the next node instead. We are just copying the data from the next node into current node and leaving
the removed node to garbage collector to clean it.
 */
/*
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
*/

class Solution {
    public void deleteNode(Node del_node) {
        // code here
        del_node.data = del_node.next.data;
        del_node.next = del_node.next.next;
    }
}