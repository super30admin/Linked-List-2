
// Time Complexity O(n)
//Space COmplexity O(1)
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
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;

        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr= temp;
        }
      

        slow = head;

        while(slow != null && prev != null ){
            ListNode temp1 = prev.next;
            ListNode temp2 = slow.next;
            slow.next = prev;
            prev.next = temp2;
            slow = temp2;
            prev = temp1;
           
        }



        
        
    }
}
