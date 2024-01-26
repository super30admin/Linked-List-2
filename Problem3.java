//Accepted on Gfg
//We just swap the data till the end and make last 2nd nodes next to null
class Solution
{
    void deleteNode(Node del)
    {
         // Your code here
         while(del!=null){
            del.data = del.next.data;
            if(del.next.next==null){
                del.next = null;
                return;
            }
            del = del.next;
         }
         return;
    }
}