// O(1),O(1)
// Approach:
// Copy the value from the next node in to the  current node
// And delete the current next node. 
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         Node temp=del;
         temp.data=temp.next.data;
         temp.next=temp.next.next;
    }
}