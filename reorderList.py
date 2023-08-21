#Time Complexity: O(n) n-No. of nodes
#Space Complexity: O(1)

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """

        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        
        curr = slow.next
        if curr is None:
            return head
        slow.next = None
        prev = None
        fast = curr.next
        while fast:
            curr.next = prev
            prev = curr
            curr = fast
            fast = fast.next
        curr.next = prev

        first = head
        second = curr
        while first and second:
            fast = first.next
            first.next = second
            second = second.next
            first.next.next = fast
            first = first.next.next 