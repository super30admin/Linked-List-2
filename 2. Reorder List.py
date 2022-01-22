class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reorderList(self, head) -> None:
        # Time Complexity - O(n)
        # Space Complexity - O(1)

        # Finding the middle of the list
        slow, fast = head, head.next

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Reversing the list
        second = slow.next
        slow.next = None
        prev = None

        while second:
            tmp = second.next
            second.next = prev
            prev = second
            second = tmp

        # Merge two halfs
        first, second = head, prev
        while second:
            tmp1 = first.next
            tmp2 = second.next
            first.next = second
            second.next = tmp1
            first, second = tmp1, tmp2