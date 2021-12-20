// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

var reorderList = function (head) {
  if (head === null || head.next === null) return;

  let slowPointer = head;
  let fastPointer = head.next;

  while (fastPointer !== null && fastPointer.next !== null) {
    slowPointer = slowPointer.next;
    fastPointer = fastPointer.next.next;
  }

  let previous = null;
  let current = slowPointer.next;
  let fast = slowPointer.next.next;

  while (fast !== null) {
    current.next = previous;
    previous = current;
    current = fast;
    fast = fast.next;
  }
  current.next = previous;

  let slow = head;
  let dummy = head.next;

  while (current !== null) {
    slow.next = current;
    current = current.next;
    slow.next.next = dummy;
    slow = dummy;
    dummy = dummy.next;
  }

  slow.next = null;
  return head;
};
