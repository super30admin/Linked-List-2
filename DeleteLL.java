
//Delete without head Pointer
class Solution
{
   void deleteNode(Node del)
   {
        int temp=del.next.data;
        del.data=temp;
        del.next=del.next.next;
   }
}

