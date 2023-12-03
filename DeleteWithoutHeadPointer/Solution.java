// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : -
// Any problem you faced while coding this : No

/**
 * Copy the value of next node into current node. Make current node point to current.next.next. With this approach, we are not deleting
 * the node's memory address, we are just changing the value of the current node.
 * If we are asked to return the head of the LinkedList, that will not be possible in a singly linked list because we cannot move
 * backwards.
 * This is just a make shift solution. If we are asked to delete the current node from the memory address, then we will need previous
 * pointer which is not possible to get in this problem.
 */
class Solution
{
    void deleteNode(Node del)
    {
        Node temp = del.next;
        del.data = temp.data;
        del.next = temp.next;
        temp = null;
    }
}

