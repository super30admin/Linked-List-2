/*
Thought Process: 
Need to copy the next's value to current and then make curr point to next's next

T.C - O(1)
S.C - O(1)

*/
//Function to delete a node without any reference to head pointer.
class DeleteWithoutHeadPointer
{
    void deleteNode(Node del)
    {
         // Your code here
        if(del.next == null)
            del = null;
        else{
            del.data = del.next.data;
            del.next = del.next.next;
        }
    }
}

