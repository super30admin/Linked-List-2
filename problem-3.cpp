// Delete without head pointer
// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
    

This code deletes a node from a singly linked list given only a pointer to that node. 
accomplishes this by copying the data of the next node into the current node and 
then bypassing the next node, effectively removing it from the list while maintaining 
the overall structure.


*/

void deleteNode(Node *del)
{
    // Your code here
    del->data = del->next->data;
    del->next = del->next->next;
}