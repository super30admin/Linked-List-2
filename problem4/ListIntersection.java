//Time Complexity : O(n+m)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem4;

import java.util.HashSet;
import java.util.Set;

public class ListIntersection {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}

		Set<ListNode> set = new HashSet<ListNode>();
		ListNode temp = headA;
		while (temp != null) {
			set.add(temp);
			temp = temp.next;
		}

		temp = headB;

		while (temp != null) {
			if (set.contains(temp)) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(3);
		node.next = new ListNode(4);
		node.next.next = new ListNode(5);

		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = node;

		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(3);
		head2.next.next.next = node;

		ListIntersection obj = new ListIntersection();
		System.out.println("Lists intersect at node with value " + obj.getIntersectionNode(head1, head2).val);

	}

}
