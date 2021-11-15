//Time Complexity: O(m+n), where m and n are the lengths of the given lists. 2 passes are made of both lists. first to get the length, second to compare elements so 2(m+n).
//Space Complexity: O(1)
//running on leetcode: yes
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null || headB==null)
        {
            return null;
        }
        //get length of list a and list b
        int lenA=0, lenB=0;
        ListNode curr=headA;
        //length of list a
        while (curr!=null)
        {
            curr=curr.next;
            lenA++;
        }
        //length of list b
        curr = headB;
        while (curr!=null)
        {
            curr=curr.next;
            lenB++;
        }
        //compare lengths and update lengths to be equal
        while (lenA > lenB)
        {
            headA=headA.next;
            lenA--;
        }
        while (lenB > lenA)
        {
            headB=headB.next;
            lenB--;
        }
        //traverse both list using pointers and find intersection
        while (headA != headB)
        {
            headA = headA.next;
            headB = headB.next;
        }
        return headB;
    }
}
