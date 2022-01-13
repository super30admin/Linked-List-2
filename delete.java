Time O(n)
Space O(1)

class Solution
{
    void deleteNode(Node del)
    {
        // Your code here

        while(del.next!=null){
            del.data=del.next.data;

            if(del.next.next==null){
                del.next=null;
            }else{
                del=del.next;
            }


        }



    }
}