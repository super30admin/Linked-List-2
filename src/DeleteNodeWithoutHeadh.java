/**
 * https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
 */

class GfG
{
    void deleteNode(Node node)
    {
         //copy next node val to current node and skip next node
         
         node.data = node.next.data;
         node.next = node.next.next;
    }
}