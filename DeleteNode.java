/*
Author: Akhilesh Borgaonkar
Problem: Delete given node in the linked list without head. (Linked List-2)
Approach: Overwriting the value of node to be delete with next node's value. Also, overwriting the next reference to next.next of node to be deleted.
Time Complexity: O(1) constant.
Space complexity: O(1) constant.
GFG verified.
*/

class GfG
{
    void deleteNode(Node node)
    {
       
         node.data = node.next.data;		//overwriting the value from next node
         node.next = node.next.next;		//overwriting the reference to next node's next node
    }
}