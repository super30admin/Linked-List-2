//Time Complexity:O(1)
//Space Complexity:O(1)
//In this problem, I'll store my next node to a temp variable and  make my next node to point to its next node.
//This problem was executed and got accepted in Geeks For Geeks.
class GfG
{
    void deleteNode(Node node)
    {
        
         Node next=node.next;
         node.data=next.data;
         node.next=node.next.next;
    }
}