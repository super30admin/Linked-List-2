/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       
		Set<ListNode> set1 = new HashSet<>();
		while (headA != null) {
			set1.add(headA);
			headA = headA.next;
		}

		while (headB != null) {
			if (set1.contains(headB))
				return headB;
			else
				headB = headB.next;
		}
		return null;
    }
}
