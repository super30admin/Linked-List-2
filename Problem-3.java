//Function to delete a node without any reference to head pointer.
//TC + SC O(1) + O(1)

class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         if(del==null) return;
         else {
             if(del.next == null) {
                 System.out.print("invalid input");
             }
             del.data = del.next.data;
             del.next = del.next.next;
         }      
    }
    
}
