/**
 * space complexity is O(1)
 * time complexity is O(n)
 */
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         Node iter = del;
         
         while(iter.next != null && iter.next.next != null) {
             iter.data = iter.next.data;
             iter = iter.next;
         }
         iter.data = iter.next.data;
         iter.next = null;
    }
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
}