/*Approach: 
If the lists aren't of same size, iterating them from their heads will not make the pointers meet at the same node since 
the pointer for the shorter list would be ahead of pointer for the longer list
1. Find out the lengths of the lists. 
2. Move the head by the difference of the lengths
3. Once the heads are pointing to same length, start iterating and check if the pointers pointers point to the same node
4. If they do, return the node
5. Else reture null

Time complexity: O(N)
Space complexity: O(1)
*/
public class Solution {
    int count1 = 0;
    int count2 = 0; 
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode trav = headA;
        while(trav!=null)
        {
            count1++;
            trav = trav.next;
        }
        
        ListNode trav2 = headB;
        while(trav2!=null)
        {
            count2++;
            trav2 = trav2.next;
        }
       
        int diff = Math.abs(count1-count2);
        int i = 0;
        if(count1>count2) 
        {
            while(i<diff && headA!=null)
            {
                headA = headA.next;
                i++;
            }
        }
        else if(count2>count1)
        {
            while(i<diff && headB!=null)
            {
                headB = headB.next;
                i++;
            }
        }
        
        while(headB!=null && headA!=null)
        {
            if(headA==headB)
                return headA;
            headB = headB.next;
            headA = headA.next;
        }
        return null;
    }
}