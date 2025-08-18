# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution:
    def reverse(self, curr):
        prev = None
        while curr:
            temp = curr.next      # store next node
            curr.next = prev      # reverse pointer
            prev = curr           # move prev forward
            curr = temp           # move curr forward
        return prev               # new head of reversed list

    def reorderList(self, head: Optional[ListNode]) -> None:
        # Step 1: Find the middle of the list
        slow = fast = head
        while fast.next is not None and fast.next.next is not None:
            fast = fast.next.next
            slow = slow.next

        # Step 2: Reverse the second half of the list
        fast = self.reverse(slow.next)
        slow.next = None  # split into two lists
        slow = head

        # Step 3: Merge two halves alternately
        while fast:
            temp = slow.next       # save next node in first half
            slow.next = fast       # link node from second half
            fast = fast.next       # advance in second half
            slow.next.next = temp  # link back to first half
            slow = slow.next.next  # move forward in merged list
