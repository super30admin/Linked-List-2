/**
Problem: https://leetcode.com/problems/reorder-list/
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
*/

/**
Approach 1
TC: O(n)
SC: O(n)
*/
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        ListNode low = head;
        ListNode high = head;
        HashMap<ListNode, ListNode> parentChildMap = new HashMap<>();

        while (high.next != null) {
            parentChildMap.put(high.next, high);
            high = high.next;
        }

        while (low != high && parentChildMap.get(high) != low) {
            high.next = null;
            high.next = low.next;
            low.next = high;
            high = parentChildMap.get(high);
            low = low.next.next;
        }
        high.next = null;
    }
}

/**
Approach 2
TC: O(n)
SC: O(1)
*/
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        
        // Divide into two lists at mid
        // List1 will either have the same number of elements as list2 or have one more than list2
        ListNode mid = getMid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        
        head2 = reverseList(head2);
        reorderList(head, head2);
    }
    
    private ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null, next = null, cur = head;
        
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    
    private void reorderList(ListNode head, ListNode head2) {
        ListNode head1 = head;
        ListNode head1next = head1.next;
        
        while (head1 != null && head2 != null) {
            head1next = head1.next;
            head1.next = head2;
            head2 = head2.next;
            head1.next.next = head1next;
            head1 = head1next;
        }
    }
}