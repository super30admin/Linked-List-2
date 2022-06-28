/*
This approach solves the problem, by shifting the value from the node after the given node, into the given node. 
It then changes the reference of the next node from the given node, to the node after the next node, and deletes
the original next node.

Did this code run on leetcode: N/A
*/
public class DeleteWithoutHead 
{   
    //Time Complexity = O(1)
    //Space Complexity = O(1)
    public void deleteWithoutHead(ListNode delete)
    {
        Listnode nextNode = delete.next;
        delete.val = nextNode.val;
        delete.next = nextNode.next;
        nextNode.next = null;
    }
}
