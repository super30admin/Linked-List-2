class IntersectionOfTwoLL{
public class ListNode {
 int val;
 ListNode next;
 ListNode(int x) {
 val = x;
 next = null;
 }
}
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB ==null)
        {

        }
        ListNode cur = headA;
        int lenA = 0;
        int lenB=0;
        while(cur!=null)
        {
            lenA++;
            cur = cur.next;
        }
        cur = headB;
        while(cur!=null)
        {
            lenB++;
            cur = cur.next;
        }
        while(lenA > lenB)
        {
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA)
        {
            headB=headB.next;
            lenB--;
        }
        while(headA!=headB)
        {
            headA=headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
//Time complexity is O(n)
//Space complexity is O(1)