//Time Complexity :O(n)
//Space Complexity:O(1)
//Microsoft Interview
//Brute Force:Take arrayList and Swap those values .Consider 2 pointer, 1 starting from start and second one ending from last.TC=O(n),SC=O(n)
//optimal Approah:Create 2 separte list the procedure
//1.Find middle of the LL
//2.Reverse the second half of the LL
//3.Merge them together

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
        if(head == null || head.next == null) return;
        //1.find the middle of the LL
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //2.Reverse the second half of LL
        fast = reverse(slow.next);
        slow.next = null;
        //3.merge the two LL together
        slow = head;
        ListNode temp = null;
        while(fast != null){
            temp = slow.next;
            slow.next = fast;
            fast = fast.next;
            slow.next.next =temp;
            slow = temp;
        }
    }
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode curr = head,fast = head.next;
        while(fast!=null){
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = prev;
        return curr;
    }
}