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
/*
    Geeksforgeeks problem : Delete without head pointer
    T.C: O(n) :: S.C: O(1)

    Solved by copying the value of the next node to the current node that we are given
    and moving to the next node. If we find that the node's next.next pointer is null,
    then we perform this operation one last time and exit the loop.

    All test cases ran successfully!
*/

// Function to delete a node without any reference to head pointer.
class Solution {
    void deleteNode(Node node) {
        // Your code here
        if (node.next == null || node == null) return;
        
        while (node != null) {
            node.data = node.next.data;
            
            if (node.next.next == null) {
                node.data = node.next.data;
                node.next = null;
            }
            
            node = node.next;
        }
    }
}