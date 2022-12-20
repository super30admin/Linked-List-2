
// Time Complexity : O(1) 
// Space Complexity :O(1)
//Did this code successfully run on geek for geeks :Yes
// Any problem you faced while coding this :


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
