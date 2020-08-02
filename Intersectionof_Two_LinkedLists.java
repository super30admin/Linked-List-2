// Time Complexity : O(m + n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

/* Calculate length of both LL as A and B
 * Calculate the difference d = | LA-LB|
 * Move d nodes in longer Linked list
 * Then move by one step in both Linked List till headA = headB*/

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;       
		next = null;
	}
}

public class Intersectionof_Two_LinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lengthA = 0;
		int lengthB = 0;

		ListNode curr = headA;  // pointing curr to head of Linked List A

		while(curr != null){    // to find length of Linked List A
			lengthA++;
			curr = curr.next;
		}

		curr = headB;   // pointing curr to head of Linked List B

		while(curr != null){    // to find length of Linked List B
			lengthB++;
			curr = curr.next;
		}

		while(lengthA > lengthB){   // if LinkedList A is greater than LinkedList B
			headA = headA.next; // move head by the difference of two LL
			lengthA--;
		}

		while(lengthB > lengthA){   // if LinkedList B is greater than LinkedList A
			headB = headB.next; // move head by the difference of two LL
			lengthB--;
		}

		while(headA != headB){  // move both the heads till they dont meet
			headA = headA.next;
			headB = headB.next;
		}

		return headA;   // return any of head
		//return headB;       
	}
}
