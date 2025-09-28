/**
TC: O(n) n: no of ndoes in th elist
SC: O(1)
Approach: by using slow and fast pointer, i will split my list into two parts. Now reverse the seond part. At the end, merge both the splitted list into one.
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
class Solution {
    public void reorderList(ListNode head) {
        if(head.next == null) return;

        ListNode slow = head, fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        ListNode prev = slow.next = null;

        while(secondHalf != null){
            ListNode temp = secondHalf.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf = temp;
        }

        secondHalf = prev;
        ListNode firstHalf = head;

        while(secondHalf != null){
            ListNode temp1 = firstHalf.next,temp2 = secondHalf.next;
            firstHalf.next = secondHalf;
            secondHalf.next = temp1;
            firstHalf = temp1;
            secondHalf = temp2;
        } 
    
        
    }
}