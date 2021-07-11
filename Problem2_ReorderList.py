# Time Complexity: O(n), where n is length of the list
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes

# Solution:

class Solution:
    def reorderList(self, head: ListNode) -> None:
        if not head:
            return

        # Find middle element
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Reverse second half of the list
        fast = self.reverse(slow.next)
        slow.next = None

        # Merge the first half with the reversed second half
        slow = head
        while fast:
            temp = slow.next
            slow.next = fast
            fast = fast.next
            slow.next.next = temp
            slow = temp

    def reverse(self, head: ListNode) -> ListNode:
        prev = None
        curr = head
        while curr:
            nxt = curr.next
            curr.next = prev
            prev = curr
            curr = nxt
        return prev

