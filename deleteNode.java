//T(N) = O(N)
//S(N) = O(1)
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         if(del.next==null)
         {
             del=null;
         }
         else{
             del.data=del.next.data;
             del.next=del.next.next;
         }
         
        
    }
}