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

/**
 Do not return anything, modify head in-place instead.
 */
// Time complexity - O(n), n = number of nodes
// Space complexity - O(1)
function reorderList(head: ListNode | null): void {
	// find middle
	// reverse 2nd half
	// reset slow fast
	// merge
	let slow = head;
	let fast = head;
	while (fast.next != null && fast.next.next !== null) {
		slow = slow.next;
		fast = fast.next.next;
	}

	fast = reverse(slow.next);
	slow.next = null;
	slow = head;

	while (fast != null) {
		let temp = slow.next;
		slow.next = fast;
		fast = fast.next;
		slow.next.next = temp;
		slow = temp;
	}
}

function reverse(head: ListNode | null) {
	let curr = head;
	let prev = null;

	while (curr !== null) {
		let temp = curr.next;
		curr.next = prev;
		prev = curr;
		curr = temp;
	}

	return prev;
}
