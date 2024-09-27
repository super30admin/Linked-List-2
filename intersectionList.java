Time Complexity-O(m+n)
Space Complexity-O(1)

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    
        ListNode temp1=headA;
        ListNode temp2=headB;
        int lenA=0,lenB=0;
        while(temp1!=null)
        {
            lenA++;
            temp1=temp1.next;
        }
         while(temp2!=null)
        {
            lenB++;
            temp2=temp2.next;
        }
        while(lenA>lenB)
        {
            headA=headA.next;
            lenA--;
        }
         while(lenA<lenB)
        {
            headB=headB.next;
            lenB--;
        }
        
        while(headA!=null && !(headA==headB))
        {
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}
