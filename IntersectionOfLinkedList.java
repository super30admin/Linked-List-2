//time complexity: O(n)
//space complexity: O(1)

class LinkedListIntersectionSolution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        int lenA=0, lenB=0;
        if(tempA==null||tempB==null)
            return null;
        while(tempA != null)
        {
            tempA = tempA.next;
            lenA++;
        }
        while(tempB != null)
        {
            tempB = tempB.next;
            lenB++;
        }
        
        tempA=headA; tempB=headB;
        while(lenA>lenB)
        {
            tempA=tempA.next;
            lenA--;
        }
        while(lenB>lenA)
        {
            tempB=tempB.next;
            lenB--;
        }

        while(tempA!=null && tempB!=null)
        {
            if(tempA==tempB)
                return tempA;
            tempA=tempA.next;
            tempB=tempB.next;
        }
        
        return null;
    }
}
    