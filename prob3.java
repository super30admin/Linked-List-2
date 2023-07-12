// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes




//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         Node temp = del.next;
         del.data = del.next.data;
         del.next = del.next.next;
    }
}