// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution
{
    void deleteNode(Node del)
    {
         del.data = del.next.data;
         del.next = del.next.next;
    }
}

//for normal deletion we require the previous node, which we can't reach because we don't have the head
//so we copy data of next node to current node then we simply delete the next node
