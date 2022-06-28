/*
The following code solves the problem by first calculating the size of the both the linked lists starting
from their given heads. Then, a difference of the sizes is taken, and the head of the list with the larger
size is moved ahead by the size differential. We then iterate over both the lists, and at each iteration we
compare and see if the nodes match, and then return the corresponding matching node.

Did this code run on leetcode: Yes
*/
public class Solution {
    //Time Complexity = O(n)
    //Space Complexity = O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {   
        int size1 = 0, size2 = 0;
        ListNode head1 = headA;
        ListNode head2 = headB;
        while(head1 != null)
        {
            size1++;
            head1 = head1.next;
        }
        
        while(head2 != null)
        {
            size2++;
            head2 = head2.next;
        }
        
        if(size1 > size2)
        {
            for(int i = 0; i < size1 - size2; i++)
                headA = headA.next;
        }
        else if(size2 > size1)
        {
            for(int i = 0; i < size2 - size1; i++)
                headB = headB.next;
        }
        
        while(headA != null)
        {
            if(headA == headB)
                return headA;
            
            else
            {
                headA = headA.next;
                headB = headB.next;
            }
        }
        
        return headA;
    }
}