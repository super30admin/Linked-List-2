//use two pointers (a and b) that traverse both lists; when one reaches the end, it jumps to the head of the other list. This ensures both pointers traverse equal lengths, and they meet at the intersection or both reach null.
//Time complexity: O(m+n)
//Space complexity: O(1)
public class intersectionOfLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA;
        ListNode b=headB;

        while(a!=b)
        {
            if(a==null) a=headB;
            else a=a.next;
            if(b==null) b=headA;
            else b=b.next;
            
        }

        return a;
    }
}