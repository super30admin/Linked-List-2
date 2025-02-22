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
        if (headA == null || headB == null)
        {
            return null;
        }

        int m = 1, n = 1;
        ListNode currentA = headA;
        ListNode currentB = headB;

        while (currentA.next != null)
        {
            m++;
            currentA = currentA.next;
        }

        while (currentB.next != null)
        {
            n++;
            currentB = currentB.next;
        }

        currentA = headA;
        currentB = headB;
        while (m > n)
        {
            currentA = currentA.next;
            m--;
        }
        while (n > m)
        {
            currentB = currentB.next;
            n--;
        }

        while (currentA != currentB)
        {
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return currentA;
    }
}