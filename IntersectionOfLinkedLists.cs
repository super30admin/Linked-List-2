// time complexity O(m+n) // Max between length of two lists
// space complexity - O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution
{
    public ListNode GetIntersectionNode(ListNode headA, ListNode headB)
    {
        int lA = GetCount(headA);
        int lB = GetCount(headB);
        int diff = Math.Abs(lA - lB);
        if (lA > lB)
        {
            while (diff > 0)
            {
                headA = headA.next;
                diff--;
            }
        }
        else
        {
            while (diff > 0)
            {
                headB = headB.next;
                diff--;
            }
        }

        while (headA != headB)
        {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int GetCount(ListNode head)
    {
        int count = 0;
        ListNode curr = head;
        while (curr != null)
        {
            count++;
            curr = curr.next;
        }
        return count;
    }
}