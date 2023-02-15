// Time Complexity : O(A+B) A & B are lengths of the lists.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

/**
 * Take two pointers for headA and headB respectively. Iterate both pointers to next pointers
 * until two pointers are not equal. When one pointer reaches null, update it to the other head.
 * Finally return any pointer as the answer.
 *
 */
class Solution {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		ListNode p1 = headA, p2 = headB;
		while (p1 != p2) {
			p1 = p1 != null ? p1.next : headB;
			p2 = p2 != null ? p2.next : headA;
		}
		return p1;
	}
}
