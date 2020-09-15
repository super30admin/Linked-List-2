import java.util.List;

public class ReorderList {
	public void reorderList(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		ListNode second_half;
		ListNode reversedList;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		second_half = slow.next;
		reversedList = reverse(second_half);
		slow.next = null;
		slow = head;
		merge(slow, reversedList);
	}

	private void merge(ListNode head, ListNode reversedList) {
		// TODO Auto-generated method stub
		ListNode slow = head;
		ListNode fast = reversedList;
		ListNode curr;
		while (fast != null) {
			curr = slow.next;
			slow.next = fast;
			fast = fast.next;
			slow.next.next = curr;
			slow = curr;
		}
	}

	private ListNode reverse(ListNode second_half) {
		// TODO Auto-generated method stub
		ListNode curr = second_half;
		ListNode prev = null;
		ListNode nextPtr = second_half.next;
		while (nextPtr != null) {
			curr.next = prev;
			prev = curr;
			curr = nextPtr;
			nextPtr = nextPtr.next;
		}
		curr.next = prev;
		return curr;

	}

}
