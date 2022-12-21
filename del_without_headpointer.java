// Time Complexity : O(1) 
// Space Complexity :O(1)


public class del_without_headpointer {
   

public class DeleteWithoutHeadPointer {

	void deleteNode(ListNode del)
    {
        if(del.next ==null)
        del = null;
        else{
           del.val = del.next.val;
           del.next = del.next.next;
        }
    }

}

}
