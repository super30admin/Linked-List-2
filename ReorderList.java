/*Approach: 
1. Use a slow pointer and a fast pointer. Move the fast pointer at 2x speed than the slow pointer
2. By the end, slow pointer will be pointing to the middle of the list 
3. Disconnect the 1st half from the last half 
4. Reverse the 2nd half of the linked list 
5. Traverse till the end of both the linked lists and merge them

Time complexity: O(N)
Space complexity: O(1)
*/
class Solution {
    public void reorderList(ListNode head) {
        ListNode sp = head;
        ListNode fp = head.next; //it is important to set fp to head.next. Because it is going with twice the speed. Not doing this would fail for [1,2] as sp would be pointing to 2
        
        if(head.next==null)   //this is an important condition, without this, fp.next would fail
            return;
        
        while(fp!=null && fp.next!=null)
        {
           sp = sp.next;
           fp = fp.next.next;
        }
        
        //reset fp to the begginging of the 2nd half of the list, that wuld be next of sp
        fp = sp.next;
       
        //disconnect sp from 2nd half
        sp.next = null;
        sp = head;
        
        //now sp points to beginning of the 1st half of the linked list and fp points to the beginning of the 2nd half of the linked list 
        ListNode p1 = null;
        ListNode p2 = fp;
        ListNode p3 = fp.next;
        
        while(p3!=null)
        {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }
        p2.next = p1;
        
        //p2 is pointing to the head of the second half and reversed linked list and sp is pointing to the 1st half of the linked list
        //use p1 to traverse 1st half and use p3 to traverse 2nd half
        
        ListNode insertWhere;
        
        while(p2!=null)  //we don't have to check for sp as the 1st half can have one more element than the second. But we will be pointing to it by the end
        {
           insertWhere = sp.next;
           sp.next = p2;
           p2 = p2.next;
           sp.next.next = insertWhere;   //sp.next.next will be pointing to the second half of the list
           sp = insertWhere;
        }
            
    }
}