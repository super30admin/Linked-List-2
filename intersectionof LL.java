/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
/*
 * public class Solution {
 * public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
 * //Tc: O(m+n) Sc: O(1)
 * ListNode cur = headA;
 * int lenA = 0;
 * while (cur != null) {
 * cur = cur.next;
 * lenA++;
 * }
 * cur = headB;
 * int lenB = 0;
 * while (cur != null) {
 * cur = cur.next;
 * lenB++;
 * }
 * 
 * while (lenA > lenB) {
 * headA = headA.next;
 * lenA--;
 * }
 * 
 * while (lenB > lenA) {
 * headB = headB.next;
 * lenB--;
 * }
 * 
 * while (headA != headB) {
 * headA = headA.next;
 * headB = headB.next;
 * }
 * return headA;
 * // return headB;
 * }
 * }
 * 
 * 
 */
/*
 * HashSet<ListNode> set = new HashSet<>();
 * while(headA != null)
 * {
 * set.add(headA);
 * headA = headA.next;
 * }
 * 
 * while(headB != null)
 * {
 * if(set.contains(headB)) return headB;
 * headB = headB.next;
 * }
 * return null;
 * 
 */