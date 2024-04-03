/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
 * class Solution {
 * public void reorderList(ListNode head) {
 * 
 * //Tc: O(N) Sc: O(1)
 * if (head == null)
 * return;
 * ListNode slow = head, fast = head;
 * while (fast != null && fast.next != null) {
 * fast = fast.next.next;
 * slow = slow.next;
 * }
 * 
 * ListNode prev = null;
 * ListNode cur = slow;
 * while (cur != null) {
 * ListNode temp = cur.next;
 * cur.next = prev;
 * prev = cur;
 * cur = temp;
 * }
 * 
 * ListNode fir = head;
 * ListNode sec = prev;
 * 
 * while (sec.next != null) {
 * ListNode temp = fir.next;
 * fir.next = sec;
 * fir = temp;
 * 
 * temp = sec.next;
 * sec.next = fir;
 * sec = temp;
 * }
 * 
 * }
 * }
 * 
 */