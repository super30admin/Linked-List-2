# The code reorders a linked list in-place by splitting it into two halves, 
# reversing the second half, and merging both halves alternately, ensuring L₀ → Lₙ → L₁ → Lₙ₋₁ → L₂ → ... order.

# Time Complexity: O(N) (Splitting, reversing, and merging each take O(N)).
# Space Complexity: O(1) (Only uses pointers, no extra space).     
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        if not head:
            return
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        prev, curr = None, slow
        while curr:
            curr.next, prev, curr = prev, curr, curr.next
        first, second = head, prev
        while second.next:
            first.next, first = second, first.next
            second.next, second = first, second.next