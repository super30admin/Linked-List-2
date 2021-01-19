/**
Delete a node without head pointer
**/

class Solution
{
    public void deleteNode(ListNode node)
    {
        //override the value of the current node with the next node
        node.val = node.next.val;
        
        //move the next pointer of the current node to point to the next of the next node
        node.next = node.next.next;
        
        // the next node will become unreferenced and will be collected by the java garbage collector
    }
}