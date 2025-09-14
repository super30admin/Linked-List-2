/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */
// Time complexity - O(m+n), m & n = number of nodes in the linkedlist
// Space complexity - O(1)
function getIntersectionNode(
	headA: ListNode | null,
	headB: ListNode | null
): ListNode | null {
	let lenA = 0;
	let lenB = 0;
	let curr = headA;

	while (curr != null) {
		curr = curr.next;
		lenA++;
	}

	curr = headB;
	while (curr != null) {
		curr = curr.next;
		lenB++;
	}

	while (lenA > lenB) {
		headA = headA.next;
		lenA--;
	}

	while (lenB > lenA) {
		headB = headB.next;
		lenB--;
	}

	while (headA != headB) {
		headA = headA.next;
		headB = headB.next;
	}

	return headA;
}
