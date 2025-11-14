/**** Method 1 ****/
//Time Complexity: O(n)
//Space Complexity: O(1)

//Successfully submitted in LeetCode

//To get the resulted output we have to divide the array into two half then reverse second part and merge the two list, to achieve this we find the mid of linked list and set the next to null as we need to two separate lists and reverse the second list and then merge them by altering the next values.

public class _143_Reorder_List {

  public void reorderList(ListNode head) {
    ListNode mid = mid(head);
    mid = reverse(mid);

    ListNode next1;
    ListNode next2;

    ListNode curr = head;

    while (curr != null && mid != null) {
      next1 = curr.next;
      next2 = mid.next;
      curr.next = mid;
      mid.next = next1;
      curr = next1;
      mid = next2;
    }
  }

  private ListNode mid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode mid = slow.next;
    slow.next = null;

    return mid;
  }

  private ListNode reverse(ListNode head) {
    ListNode prev = null;

    ListNode curr = head;

    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }
}
