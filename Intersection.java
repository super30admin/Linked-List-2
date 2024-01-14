// Time Complexity : O(M + N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :Y
// Any problem you faced while coding this :

public class Intersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode curr = headA;
        while(curr !=null)
        {
            lenA++;
            curr = curr.next;
        }
        curr = headB;
        while(curr !=null)
        {
            lenB++;
            curr = curr.next;
        }
        while(lenA > lenB)
        {
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA)
        {
            headB = headB.next;
            lenB--;
        }
        while(headA != headB)
        {
            headA = headA.next;
            headB = headB.next;
        }
        return headB;
}

public static void main(String args [])
{
    Intersection list = new Intersection();
    ListNode node = new ListNode(4);
    node.next = new ListNode(1);
    node.next.next = new ListNode(8);
    node.next.next.next = new ListNode(4);
    node.next.next.next.next = new ListNode(5);
    ListNode second = new ListNode(5);
    second.next = new ListNode(6);
    second.next.next = new ListNode(1);
    second.next.next.next =  node.next.next;
    System.out.println(list.getIntersectionNode(node,second).val);
}

}
