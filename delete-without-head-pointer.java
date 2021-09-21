//Time complexity: O(1)
//Space complexity: O(1)
class Solution
{
    void deleteNode(Node del)
    {
        //current data of del node will be replaced by the next node data
        del.data = del.next.data;
        //current next will point to next.next
        del.next = del.next.next;
    }
}