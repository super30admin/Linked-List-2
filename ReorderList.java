/*
Time Complexity : O(n)
    1. Finding the Middle:

    The slow pointer traverses up to the middle of the list while the fast pointer moves twice as fast.
    The number of nodes traversed by slow is n/2 in the worst case.
    Time Complexity: O(n/2).

    2. Reversing the Second Half:

    The reverse function processes the second half of the list, which consists of approximately n/2 nodes.
    Time Complexity: O(n/2).

    3. Merging Two Halves:

    During the merge, alternating between the two halves, n/2 iterations are performed in the worst case.
    Time Complexity: O(n/2).

    O(n/2) + O(n/2) + O(n/2) = 3⋅O(n/2) => O(n)

Space Complexity : O(1)

 Did this code successfully run on Leetcode: Yes
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReorderList {
    public void reorderList(ListNode head)
    {
        //Part1: middle identification
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) //checking both even and odd
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Post the above while loop slow pointer will reach the middle of the list {second middle in case of even numbers}

        /*
            Part2: Reverse the List
            Here the reverse function will be giving the reverse of second part of the list and we will make fast pointer pointing to the
            head of the reversed list
            After which we will be removing the connection of slow.next
        */
        fast = reverse(slow.next);
        slow.next = null;

        //Part3: Reorder the list
        slow = head;
        while(fast != null && slow != null)
        {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next = temp;
            slow = temp;
        }
    }

    private ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode curr = head;

        /*
          null      1    ->  2   ->  3   ->  null
            ↑       ↑        ↑
          prev    curr     temp
        */

        while(curr != null)
        {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }
}
